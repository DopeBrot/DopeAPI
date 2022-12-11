package de.dopebrot.dopeapi.language;

import de.dopebrot.dopeapi.config.DPConfig;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

public class LanguageManager {

	private final File languageFolder;
	private final ArrayList<Language> languages;
	private final HashMap<String, Language> languageIdentifier;
	private boolean debug = false;
	private String errorMessage;

	/**
	 * creates a new Language Manager
	 * @param folder where are all the language configs saved
	 * @apiNote all files in this directory need to be an "*.json"
	 */
	public LanguageManager(File folder) {
		this.languageFolder = folder;
		this.errorMessage = "%key%:%message% was not found report this to an administrator";
		this.languages = new ArrayList<>();
		this.languageIdentifier = new HashMap<>();
		if (!languageFolder.isDirectory()) {
			Bukkit.getLogger().log(Level.WARNING, "language folder is not a directory!");
		}
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	/**
	 * if debug messages should be shown
	 *
	 * @param debug true or false
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * logs messages in console
	 *
	 * @param s String that is written
	 */
	private void log(String s) {
		Bukkit.getLogger().log(Level.WARNING, s);
	}

	/**
	 * sets the error message if the message is not found
	 * @param errorMessage string of the new message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @apiNote gets all files from language folder and puts them in memory.
	 */
	public void load() {
		if (languageFolder.isDirectory()) {
			if (languageFolder.listFiles() != null) {
				for (File currentFile : languageFolder.listFiles()) {
					if (currentFile != null) {
						if (currentFile.getName().contains(".json")) {
							if (debug) {
								log("loading: " + currentFile.getName());
							}
							DPConfig tmpConfig = new DPConfig(currentFile, true);
							if (tmpConfig.getJsonObject().has("language")) {
								if (debug) {
									log("adding " + currentFile.getName() + " to list.");
								}
								Language language = new Language(currentFile, tmpConfig);
								language.load();
								this.languages.add(language);
							}
						}
					}
				}
			}
		}

		if (!this.languages.isEmpty()) {
			for (Language currentLanguage : languages) {
				languageIdentifier.put(currentLanguage.key(), currentLanguage);
			}
		}
	}

	/**
	 * @param key     key of the language (key could be "en" for English)
	 * @param message the message that is searched (message could be "player_disconnect")
	 * @return either an error string that the message couldn't be found or the actual message.
	 */
	public String getString(String key, String message) {
		if (languageIdentifier.containsKey(key)) {
			if (languageIdentifier.get(key).has(message)) {
				return languageIdentifier.get(key).message(message);
			}
		}
		return errorMessage.replace("%key%", key).replace("%message%", message);
	}

}
