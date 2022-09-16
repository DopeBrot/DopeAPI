package de.dopebrot.dopeapi.helper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

public class DPConfig {

	private final File file;
	private final YamlConfiguration yamlConfiguration;
	private boolean autoSave = true;

	public DPConfig(File file) {
		Validate.notNull(file, "file can't be null!");
		this.file = file;
		this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	public void setAutoSave(boolean b) {
		this.autoSave = b;
	}

	/**
	 * saves the file
	 */
	public void save() {
		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * is used by methods
	 */
	private void autoSave() {
		if (autoSave) {
			try {
				yamlConfiguration.save(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * @param log should log
	 */
	public void createNewFile(boolean log) {
		if (file.mkdirs()) {
			try {
				if (file.createNewFile()) {
					if (log) {
						Bukkit.getLogger().log(Level.INFO, "file (" + file.getName() + ") created at (" + file.getPath() + ")");
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * @param path          relative path to values
	 * @param location      which location should be stored
	 * @param locationLevel which level of location should be stored
	 */
	public void setLocation(String path, Location location, LocationLevel locationLevel) {
		Validate.notNull(path, "path can't be null!");
		Validate.notEmpty(path, "path can't be empty");
		Validate.notNull(location, "location can't be null!");
		Validate.notNull(locationLevel, "locationLevel can't be null!");
		yamlConfiguration.set(path + "w", location.getWorld().getName());
		switch (locationLevel) {
			case POS -> {
				yamlConfiguration.set(path + ".x", location.getX());
				yamlConfiguration.set(path + ".y", location.getY());
				yamlConfiguration.set(path + ".z", location.getZ());
			}
			case POS_BLOCK -> {
				yamlConfiguration.set(path + ".xb", location.getBlockX());
				yamlConfiguration.set(path + ".yb", location.getBlockY());
				yamlConfiguration.set(path + ".zb", location.getBlockZ());
			}
			case POS_DIRECTION -> {
				yamlConfiguration.set(path + ".x", location.getX());
				yamlConfiguration.set(path + ".y", location.getY());
				yamlConfiguration.set(path + ".z", location.getZ());
				yamlConfiguration.set(path + ".yaw", location.getYaw());
				yamlConfiguration.set(path + ".pitch", location.getPitch());
			}
			case POS_BLOCK_DIRECTION -> {
				yamlConfiguration.set(path + ".xb", location.getBlockX());
				yamlConfiguration.set(path + ".yb", location.getBlockY());
				yamlConfiguration.set(path + ".zb", location.getBlockZ());
				yamlConfiguration.set(path + ".yaw", location.getYaw());
				yamlConfiguration.set(path + ".pitch", location.getPitch());
			}
			case POS_DIRECTION_ROUND -> {
				yamlConfiguration.set(path + ".x", location.getX());
				yamlConfiguration.set(path + ".y", location.getY());
				yamlConfiguration.set(path + ".z", location.getZ());
				yamlConfiguration.set(path + ".yaw", Math.round(location.getYaw()));
				yamlConfiguration.set(path + ".pitch", Math.round(location.getPitch()));
			}
			case POS_BLOCK_DIRECTION_ROUND -> {
				yamlConfiguration.set(path + ".xb", location.getBlockX());
				yamlConfiguration.set(path + ".yb", location.getBlockY());
				yamlConfiguration.set(path + ".zb", location.getBlockZ());
				yamlConfiguration.set(path + ".yaw", Math.round(location.getYaw()));
				yamlConfiguration.set(path + ".pitch", Math.round(location.getPitch()));
			}
		}
		autoSave();
	}

	/**
	 * @param path relative path to values
	 * @return a bukkit location
	 */
	public Location getLocation(String path) {
		Validate.notNull(path, "path can't be null!");
		Validate.notEmpty(path, "path can't be empty");

		if (!yamlConfiguration.contains(path + ".w")) {
			Bukkit.getLogger().log(Level.WARNING, "path[" + path + ".w" + "] not found!");
			return new Location(Bukkit.getWorld("world"), 0, 0, 0);
		}
		String worldName = yamlConfiguration.getString(path + ".w");
		if (worldName == null)
			throw new NullPointerException("world name is null");
		if (!worldName.isEmpty())
			throw new NullPointerException("world name is empty");
		World w = Bukkit.getWorld(worldName);
		if (w == null) {
			Bukkit.getLogger().log(Level.WARNING, "world[" + worldName + "] not found!");
			if (Bukkit.getWorlds().size() > 0)
				w = Bukkit.getWorlds().get(0);
			if (w == null)
				throw new NullPointerException("worlds fatal error");
			Bukkit.getLogger().log(Level.WARNING, "using [" + w.getName() + "] instead!");
		}

		if (yamlConfiguration.contains(path + ".xb")) {
			if (yamlConfiguration.contains(path + ".yb")) {
				if (yamlConfiguration.contains(path + ".zb")) {
					if (yamlConfiguration.contains(path + ".pitch")) {
						if (yamlConfiguration.contains(path + ".yaw")) {
							float yaw = (float) yamlConfiguration.getDouble(path + ".yaw");
							float pitch = (float) yamlConfiguration.getDouble(path + ".pitch");
							int xb = yamlConfiguration.getInt(path + ".xb");
							int yb = yamlConfiguration.getInt(path + ".yb");
							int zb = yamlConfiguration.getInt(path + ".zb");
							return new Location(w, xb, yb, zb, yaw, pitch);
						}
					}
					int xb = yamlConfiguration.getInt(path + ".xb");
					int yb = yamlConfiguration.getInt(path + ".yb");
					int zb = yamlConfiguration.getInt(path + ".zb");
					return new Location(w, xb, yb, zb);
				}
			}
		}

		if (yamlConfiguration.contains(path + ".x")) {
			if (yamlConfiguration.contains(path + ".x")) {
				if (yamlConfiguration.contains(path + ".x")) {
					if (yamlConfiguration.contains(path + ".pitch")) {
						if (yamlConfiguration.contains(path + ".yaw")) {
							float x = (float) yamlConfiguration.getDouble(path + ".x");
							float y = (float) yamlConfiguration.getDouble(path + ".y");
							float z = (float) yamlConfiguration.getDouble(path + ".z");
							float yaw = (float) yamlConfiguration.getDouble(path + ".yaw");
							float pitch = (float) yamlConfiguration.getDouble(path + ".pitch");
							return new Location(w, x, y, z, yaw, pitch);
						}
					}
					float x = (float) yamlConfiguration.getDouble(path + ".x");
					float y = (float) yamlConfiguration.getDouble(path + ".y");
					float z = (float) yamlConfiguration.getDouble(path + ".z");
					return new Location(w, x, y, z);
				}
			}
		}

		return null;
	}

	/**
	 * @param path      relative path to itemstack
	 * @param itemStack itemstack which will be stored
	 */
	public void setItemStack(String path, ItemStack itemStack) {
		Validate.notNull(path, "path can't be null!");
		Validate.notEmpty(path, "path can't be empty");
		Validate.notNull(itemStack, "itemStack can't be null!");

		Map<String, Object> serItem = itemStack.serialize();
		yamlConfiguration.createSection(path + ".itemstack", serItem);

		autoSave();
	}

	/**
	 * @param path relative path to itemstack
	 * @return ItemStack or null if path is not found
	 */
	public ItemStack getItemStack(String path) {
		Validate.notNull(path, "path can't be null!");
		Validate.notEmpty(path, "path can't be empty");
		if (!yamlConfiguration.contains(path + ".itemstack"))
			throw new NullPointerException("path [" + path + ".itemstack] does not exist");
		Map<String, Object> serItem = (Map<String, Object>) yamlConfiguration.getMapList(path + "itemstack");
		return ItemStack.deserialize(serItem);
	}

}

enum LocationLevel {
	/**
	 * location without yaw and pitch
	 */
	POS,

	/**
	 * location as block without yaw and pitch
	 */
	POS_BLOCK,

	/**
	 * location with yaw and pitch
	 */
	POS_DIRECTION,

	/**
	 * location as block with yaw and pitch
	 */
	POS_BLOCK_DIRECTION,

	/**
	 * location with yaw and pitch rounded
	 */
	POS_DIRECTION_ROUND,

	/**
	 * location as block with yaw and pitch rounded
	 */
	POS_BLOCK_DIRECTION_ROUND;
}