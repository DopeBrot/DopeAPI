package de.dopebrot.dopeapi.helper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.logging.Level;

public class DPConfig {

	private File file;
	private YamlConfiguration yamlConfiguration;

	public DPConfig(File file) {
		this.file = file;
		this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	/**
	 * @param log if true logs that a file was created
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

	public void setLocation(String path, Location location, LocationLevel locationLevel) {
		Validate.notNull(location, "location can't be null!");
		Validate.notNull(locationLevel, "locationLevel can't be null!");
		yamlConfiguration.set(path + "w", location.getWorld().getName());
		switch (locationLevel) {
			case POS -> {
				yamlConfiguration.set(path + "x", location.getX());
				yamlConfiguration.set(path + "y", location.getY());
				yamlConfiguration.set(path + "z", location.getZ());
			}
			case POS_BLOCK -> {
				yamlConfiguration.set(path + "x", location.getBlockX());
				yamlConfiguration.set(path + "y", location.getBlockY());
				yamlConfiguration.set(path + "z", location.getBlockZ());
			}
			case POS_DIRECTION -> {
				yamlConfiguration.set(path + "x", location.getX());
				yamlConfiguration.set(path + "y", location.getY());
				yamlConfiguration.set(path + "z", location.getZ());
				yamlConfiguration.set(path + "yaw", location.getYaw());
				yamlConfiguration.set(path + "pitch", location.getPitch());
			}
			case POS_BLOCK_DIRECTION -> {
				yamlConfiguration.set(path + "x", location.getBlockX());
				yamlConfiguration.set(path + "y", location.getBlockY());
				yamlConfiguration.set(path + "z", location.getBlockZ());
				yamlConfiguration.set(path + "yaw", location.getYaw());
				yamlConfiguration.set(path + "pitch", location.getPitch());
			}
			case POS_DIRECTION_ROUND -> {
				yamlConfiguration.set(path + "x", location.getX());
				yamlConfiguration.set(path + "y", location.getY());
				yamlConfiguration.set(path + "z", location.getZ());
				yamlConfiguration.set(path + "yaw", Math.round(location.getYaw()));
				yamlConfiguration.set(path + "pitch", Math.round(location.getPitch()));
			}
			case POS_BLOCK_DIRECTION_ROUND ->  {
				yamlConfiguration.set(path + "x", location.getBlockX());
				yamlConfiguration.set(path + "y", location.getBlockY());
				yamlConfiguration.set(path + "z", location.getBlockZ());
				yamlConfiguration.set(path + "yaw", Math.round(location.getYaw()));
				yamlConfiguration.set(path + "pitch", Math.round(location.getPitch()));
			}

		}

	}

	public Location getLocation() {
		return null;
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
