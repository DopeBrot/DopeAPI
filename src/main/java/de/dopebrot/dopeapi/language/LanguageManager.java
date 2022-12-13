package de.dopebrot.dopeapi.language;

import de.dopebrot.dopeapi.config.DPConfig;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;

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
	private String defaultLanguageKey = "null";

	/**
	 * creates a new Language Manager
	 *
	 * @param folder where are all the language configs saved
	 * @apiNote all files in this directory need to be an "*.json"
	 */
	public LanguageManager(File folder) {
		Validate.notNull(folder);
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
		Validate.notEmpty(s);
		Bukkit.getLogger().log(Level.WARNING, s);
	}

	/**
	 * sets the error message if the message is not found
	 *
	 * @param errorMessage string of the new message
	 */
	public void setErrorMessage(String errorMessage) {
		Validate.notEmpty(errorMessage);
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
							if (tmpConfig.jsonObject().has("language")) {
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
		Validate.notEmpty(key);
		Validate.notEmpty(message);
		if (languageIdentifier.containsKey(key)) {
			if (languageIdentifier.get(key).has(message)) {
				return languageIdentifier.get(key).message(message);
			}
		}
		if (!defaultLanguageKey.equals("null")) {
			if (languageIdentifier.get(defaultLanguageKey).has(message)) {
				return languageIdentifier.get(defaultLanguageKey).message(message);
			}
		}
		return errorMessage.replace("%key%", key).replace("%message%", message);
	}

	/**
	 * sets the default language key if the key cant be found it will use this key instead
	 *
	 * @param key the key of the default language ("en")
	 */
	public void setDefaultLanguageKey(String key) {
		Validate.notEmpty(key);
		if (!languageIdentifier.containsKey(key)) {
			log("default key > " + key + " couldn't be found and will not be set as default");
			return;
		}
		this.defaultLanguageKey = key;
	}

	/**
	 * @param key the key of the language that need to be found
	 * @return if the language can be found
	 */
	public boolean hasLanguage(String key) {
		Validate.notEmpty(key);
		return languageIdentifier.containsKey(key);
	}
	
	public ArrayList<Language> getLanguages() {
		return languages;
	}

	public HashMap<String, Language> getLanguageIdentifier() {
		return languageIdentifier;
	}

}
