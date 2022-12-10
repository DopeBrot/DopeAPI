package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.helper.LanguageHelper;
import de.dopebrot.dopeapi.structure.Structure;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private LanguageHelper language;
	private boolean debug;
	private String prefix = "§a[DopeAPI]";
	public final String permissionBase = "dpapi.";
	public ArrayList<DPCommand> commands;
	private Structure structure;

	public void log(String s) {
		this.getLogger().log(Level.INFO, s);
	}

	public void onEnable() {
		this.debug = false;
		registerCommands();
		loadDefaultConfigs();
		loadConfig();
		loadLanguage();
	}

	private void getResourceFile(String fileName, File file) {
		InputStream inputStream = this.getResource(fileName);
		try {
			assert inputStream != null;
			FileUtils.copyInputStreamToFile(inputStream, file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * copy's default configs and adds it to folders if they not exist
	 */
	private void loadDefaultConfigs() {
		if (new File("plugins/DopeAPI/").mkdirs()) {
			if (debug) {
				Bukkit.getLogger().log(Level.CONFIG, "dirs where created!");
			}
		}
		if (!new File("plugins/DopeAPI/config.yml").exists()) {
			if (debug)
				Bukkit.getLogger().log(Level.CONFIG, "loading config from jar : config");
			getResourceFile("config.yml", new File("plugins/DopeAPI/config.yml"));
		}
		if (!new File("plugins/DopeAPI/language.yml").exists()) {
			if (debug)
				Bukkit.getLogger().log(Level.CONFIG, "loading config from jar : config");
			getResourceFile("language.yml", new File("plugins/DopeAPI/language.yml"));
		}
	}

	/**
	 * load default configs
	 */
	private void loadConfig() {
		File f = new File("plugins/DopeAPI/config.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
		if (config.contains("debug")) {
			this.debug = config.getBoolean("debug", false);
		}
	}


	private void loadLanguage() {
		language = new LanguageHelper("language", "plugins/DopeAPI", "lang");
		language.load();
		Bukkit.getLogger().log(Level.INFO, getString("main.language"));
		prefix = getString("prefix");
	}
	/**
	 * @param key key of text e.g. (command.help.lack.permission)
	 * @return text or null of the key cant be found!
	 */
	public String getString(String key) {
		return language.getString(key);
	}

	/**
	 * registers commands
	 */
	private void registerCommands() {
	}

	public void onDisable() {

	}

}
