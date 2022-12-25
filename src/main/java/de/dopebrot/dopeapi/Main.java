package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.helper.DPJava;
import de.dopebrot.dopeapi.language.LanguageManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private LanguageManager languageManager;
//	public ArrayList<DPCommand> commands;
	private final String version = "9.0.0";

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
		//		ConsoleText consoleText = new ConsoleText();
		//		consoleText.write("TEST");
	}

	public void onDisable() {
		log(getString("en", "plugin.unloading").replace("%0%", version));
	}

}
