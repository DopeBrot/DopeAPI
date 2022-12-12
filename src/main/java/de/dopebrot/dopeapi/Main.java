package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.language.LanguageManager;
import de.dopebrot.dopeapi.structure.Structure;
import org.apache.commons.io.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private LanguageManager languageManager;
	private boolean debug;
	private final String prefix = "§a[DopeAPI]";
	public final String permissionBase = "dpapi.";
	public ArrayList<DPCommand> commands;
	private final String version = "8.0.0";
	private Structure structure;

	public void log(String s) {
		this.getLogger().log(Level.INFO, s);
	}

	public void onEnable() {
		this.debug = false;
		registerCommands();
		loadDefaultConfigs();
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
		if (!new File("plugins/DopeAPI/lang/english.json").exists()) {
			getResourceFile("english.json", new File("plugins/DopeAPI/lang/english.json"));
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
