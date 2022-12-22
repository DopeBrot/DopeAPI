package de.dopebrot.dopeapi.structure;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

/**
 * The type Animated structure.
 */
public class AnimatedStructure {

	private final ArrayList<StructureKeyFrame> structureKeyFrames;
	private final Plugin plugin;
	private final int period;
	private int taskID;
	private int currentFrame;
	private Location setSpawn;

	/**
	 * Instantiates a new Animated structure.
	 *
	 * @param plugin        the plugin
	 * @param period        the period
	 * @param spawnLocation the spawn location
	 */
	public AnimatedStructure(Plugin plugin, int period, Location spawnLocation) {
		this.structureKeyFrames = new ArrayList<>();
		this.setSpawn = spawnLocation;
		this.plugin = plugin;
		this.period = period;
		this.currentFrame = 0;
		this.taskID = 0;
	}

	/**
	 * Add key frame.
	 *
	 * @param keyFrame the key frame
	 */
	public void addKeyFrame(StructureKeyFrame keyFrame) {
		Validate.notNull(keyFrame);
		structureKeyFrames.add(keyFrame);
	}

	/**
	 * Sets key frame.
	 *
	 * @param keyFrame the key frame
	 * @param index    the index
	 */
	public void setKeyFrame(StructureKeyFrame keyFrame, int index) {
		Validate.notNull(keyFrame);
		structureKeyFrames.set(index, keyFrame);
	}

	/**
	 * Remove key frame.
	 *
	 * @param index the index
	 */
	public void removeKeyFrame(int index) {
		structureKeyFrames.remove(index);
	}

	private void updateAnimation() {
		if (currentFrame > structureKeyFrames.size()) {currentFrame = 0;}
		this.structureKeyFrames.get(currentFrame).getStructure().spawn(setSpawn);
		currentFrame++;
	}

	/**
	 * Start animation.
	 */
	public void startAnimation() {
		this.taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::updateAnimation, 0, period);
	}

	/**
	 * Stop animation.
	 */
	public void stopAnimation() {
		if (Bukkit.getScheduler().isCurrentlyRunning(this.taskID)) {
			Bukkit.getScheduler().cancelTask(taskID);
		}
	}

}
