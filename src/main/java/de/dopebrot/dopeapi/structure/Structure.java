package de.dopebrot.dopeapi.structure;
import de.dopebrot.dopeapi.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class Structure {

	private StructureBlock[] list;
	private YamlConfiguration config;
	private boolean structureLoaded;

	public Structure() {
		this.structureLoaded = false;
		this.config = new YamlConfiguration();
	}

	/**
	 * saves structure in memory
	 *
	 * @param region the region of the Structure
	 */
	public void save(Region region) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int x = 0; x < region.size()[0]; x++) {
			for (int y = 0; y < region.size()[1]; y++) {
				for (int z = 0; z < region.size()[2]; z++) {
					stringBuilder.append("#");
					stringBuilder.append(x);
					stringBuilder.append(":");
					stringBuilder.append(y);
					stringBuilder.append(":");
					stringBuilder.append(z);
					stringBuilder.append(":");
					stringBuilder.append(region.getStart().getWorld().getBlockAt(region.getStart().getBlockX() + x, region.getStart().getBlockY() + y, region.getStart().getBlockZ() + z).getBlockData().getAsString());
				}
			}
		}
		config.set("b", "" + stringBuilder + "");
	}

	/**
	 * exports config to a file
	 *
	 * @param file the file that is written to
	 */
	public void exportConfig(File file) {
		try {
			config.save(file);
		} catch (IOException ignore) {
		}

	}

	/**
	 * loads a file in to memory
	 *
	 * @param file that is being loaded
	 */
	public void importConfig(File file) {
		this.config = new YamlConfiguration();
		this.structureLoaded = true;
		try {
			this.config.load(file);
		} catch (IOException | InvalidConfigurationException ignore) {
		}

		String blockTag = this.config.getString("b", "");
		String[] blockSplit = blockTag.split("#");
		this.list = new StructureBlock[blockSplit.length + 1];
		int counter = 1;

		for (String inBlockTag : blockSplit) {
			if (inBlockTag == null || inBlockTag.equals("")) {
				break;
			}
			String[] currentBlock = inBlockTag.split(":");
			list[counter] = new StructureBlock(Integer.parseInt(currentBlock[0]), Integer.parseInt(currentBlock[1]), Integer.parseInt(currentBlock[2]), currentBlock[3]);
			counter++;
		}
	}

	/**
	 * spawns structure if it was loaded
	 *
	 * @param location the location where the structure is being build
	 */
	public void spawn(Location location) {
		if (!structureLoaded) {
			return;
		}
		for (StructureBlock block : list) {
			if (block == null) {
				break;
			}
			Block b = location.getWorld().getBlockAt(location.getBlockX() + block.x(), location.getBlockY() + block.y(), location.getBlockZ() + block.z());
			b.setBlockData(Bukkit.createBlockData(block.blockData()));
		}
	}

	/**
	 * unloads structure from memory to save memory
	 */
	public void unload() {
		this.list = null;
		this.structureLoaded = false;
	}

	/**
	 * list of all structure blocks
	 *
	 * @return list of structure blocks
	 */
	@Nullable
	public StructureBlock[] getList() {
		return this.list;
	}

	/**
	 * configuration
	 *
	 * @return a yaml configuration
	 */
	@Nullable
	public YamlConfiguration getConfig() {
		return this.config;
	}

	/**
	 * @return true if the structure is loaded in memory
	 */
	public boolean isStructureLoaded() {
		return this.structureLoaded;
	}

}
