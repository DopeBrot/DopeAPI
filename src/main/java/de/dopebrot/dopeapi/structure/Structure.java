package de.dopebrot.dopeapi.structure;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import de.dopebrot.dopeapi.config.DPConfig;
import de.dopebrot.dopeapi.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Arrays;

public class Structure {

	private StructureBlock[] list;
	private DPConfig config;
	private boolean structureLoaded;
	private int sizeX = 0;
	private int sizeY = 0;
	private int sizeZ = 0;

	/**
	 * this is a beta version
	 * it will work but lacks some features.
	 * */

	public Structure() {
		this.config = new DPConfig();
		this.structureLoaded = false;
	}

	public void testDebug() {
		if (structureLoaded) {

		}

	}

	/**
	 * loads a structure in memory
	 *
	 * @param region the region of the Structure
	 */
	public void load(Region region) {
		System.out.println(region);

		int counter = 0;
		list = new StructureBlock[((int) region.size()[0])];
		for (int x = 0; x < region.size()[1]; x++) {
			for (int y = 0; y < region.size()[2]; y++) {
				for (int z = 0; z < region.size()[3]; z++) {
					String data = region.getStart().getWorld().getBlockAt(region.getStart()).getLocation().add(x, y, z).getBlock().getBlockData().getAsString();
					if (counter >= list.length) {
						break;
					}
					list[counter] = new StructureBlock(x, y, z, data);
					counter++;
				}
			}
		}
		this.structureLoaded = true;
	}

	/**
	 * exports config to a file
	 *
	 * @param file the file that is written to
	 */
	public void exportConfig(File file) {
		if (structureLoaded) {
			JsonObject blocksObject = new JsonObject();
			JsonArray blocksArray = new JsonArray();
			for (StructureBlock structureBlock : list) {
				if (structureBlock == null) {
					continue;
				}
				JsonObject tmpBlock = new JsonObject();
				tmpBlock.add("x", new JsonPrimitive(structureBlock.x()));
				tmpBlock.add("y", new JsonPrimitive(structureBlock.y()));
				tmpBlock.add("z", new JsonPrimitive(structureBlock.z()));
				tmpBlock.add("data", new JsonPrimitive(structureBlock.blockData()));
				blocksArray.add(tmpBlock);
			}
			blocksObject.add("blocks", blocksArray);
			config.jsonObject().add("structure", blocksObject);
			config.file(file);
			config.save();
		}
	}

	/**
	 * loads a file in to memory
	 *
	 * @param file that is being loaded
	 */
	public void importConfig(File file) {
		this.config = new DPConfig(file, true);
		if (config.jsonObject().has("structure")) {
			JsonObject structureObject = config.jsonObject().getAsJsonObject("structure");
			JsonArray blockArray = structureObject.getAsJsonArray("blocks");
			if (!blockArray.isEmpty()) {
				for (int i = 0; i < blockArray.size(); i++) {
					this.list = new StructureBlock[blockArray.size()];
					JsonObject obj = blockArray.get(i).getAsJsonObject();
					list[i] = new StructureBlock(
							obj.getAsJsonPrimitive("x").getAsInt(),
							obj.getAsJsonPrimitive("y").getAsInt(),
							obj.getAsJsonPrimitive("z").getAsInt(),
							obj.getAsJsonPrimitive("data").getAsString());
				}

				this.structureLoaded = true;
				return;
			}
			this.list = new StructureBlock[0];
		}
	}

	/**
	 * spawns structure if it was loaded
	 *
	 * @param location the location where the structure is being build
	 */
	public void spawn(Location location) {
		if (structureLoaded) {
			for (StructureBlock block : list) {
				if (block == null) {
					continue;
				}
				Block b = location.getWorld().getBlockAt(location.getBlockX() + block.x(), location.getBlockY() + block.y(), location.getBlockZ() + block.z());
				b.setBlockData(Bukkit.createBlockData(block.blockData()));
			}
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
	public DPConfig getConfig() {
		return this.config;
	}

	/**
	 * @return true if the structure is loaded in memory
	 */
	public boolean isStructureLoaded() {
		return this.structureLoaded;
	}

	@Override
	public String toString() {
		return "Structure{" +
				"list=" + Arrays.toString(list) +
				", config=" + config +
				", structureLoaded=" + structureLoaded +
				", sizeX=" + sizeX +
				", sizeY=" + sizeY +
				", sizeZ=" + sizeZ +
				'}';
	}

}
