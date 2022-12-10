package de.dopebrot.dopeapi.structure;
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
	 */
	public void save(Location location, int[] size) {
		if (size.length != 3) {
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int x = 0; x < size[0]; x++) {
			for (int y = 0; y < size[1]; y++) {
				for (int z = 0; z < size[2]; z++) {
					stringBuilder.append("#");
					stringBuilder.append(x);
					stringBuilder.append(":");
					stringBuilder.append(y);
					stringBuilder.append(":");
					stringBuilder.append(z);
					stringBuilder.append(":");
					stringBuilder.append(location.getWorld().getBlockAt(location.getBlockX() + x, location.getBlockY() + y, location.getBlockZ() + z).getBlockData().getAsString());
				}
			}
		}
		config.set("b", "" + stringBuilder + "");
	}


	/**
	 * exports config
	 */
	public void exportConfig(File file) {
		try {
			config.save(file);
		} catch (IOException ignore) {
		}

	}

	/**
	 * loads config
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
	 * unloads structure from memory to save it.
	 */
	public void unload() {
		this.list = null;
	}

	@Nullable
	public StructureBlock[] getList() {
		return list;
	}

	@Nullable
	public YamlConfiguration getConfig() {
		return config;
	}

	public boolean isStructureLoaded() {
		return structureLoaded;
	}

}
