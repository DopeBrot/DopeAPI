package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.helper.DPJava;
import de.dopebrot.dopeapi.language.LanguageManager;
import de.dopebrot.dopeapi.structure.Structure;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private LanguageManager languageManager;
	private final String prefix = "§a[DopeAPI]";
	public final String permissionBase = "dpapi.";
	public ArrayList<DPCommand> commands;
	private final String version = "8.0.0";
	private Structure structure;

	public void log(String s) {
		log(Level.INFO, s);
	}

	public void log(Level level, String s) {
		this.getLogger().log(level, s);
	}

	public void onEnable() {
		registerCommands();
		loadDefaultConfigs();
		loadLanguage();
		for (String line : DPJava.getResourceFile(this, "console.txt").lines().toList()) {
			log(Level.INFO, line);
		}
	}

	/**
	 * copy's default configs and adds it to folders if they not exist
	 */
	private void loadDefaultConfigs() {
		if (!new File("plugins/DopeAPI/lang/english.json").exists()) {
			DPJava.getResourceFile(this, "english.json", new File("plugins/DopeAPI/lang/english.json"));
		}
	}

	/**
	 * loads languages
	 */
	private void loadLanguage() {
		this.languageManager = new LanguageManager(new File("plugins/DopeAPI/lang"));
		languageManager.setDebug(true);
		languageManager.load();
		log(getString("en", "plugin.loading").replace("%0%", version));
	}
	/**
	 * @param key key of text e.g. (command.help.lack.permission)
	 * @return text or null of the key cant be found!
	 */
	public String getString(String key, String message) {
		return languageManager.getString(key, message);
	}

	/**
	 * registers commands
	 */
	private void registerCommands() {
	}

	public void onDisable() {
		log(getString("en", "plugin.unloading").replace("%0%", version));
	}

}
