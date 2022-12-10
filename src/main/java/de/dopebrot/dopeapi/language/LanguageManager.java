package de.dopebrot.dopeapi.language;

import de.dopebrot.dopeapi.config.DPConfig;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

public class LanguageManager {

	private final File languageFolder;
	private final ArrayList<Language> languages;
	private final HashMap<String, Language> keyedMap;
	private boolean debug = false;
	private String errorMessage;

	public LanguageManager(File folder) {
		this.languageFolder = folder;
		this.errorMessage = "%key%:%message% was not found report this to an administrator";
		this.languages = new ArrayList<>();
		this.keyedMap = new HashMap<>();
		if (!languageFolder.isDirectory()) {
			Bukkit.getLogger().log(Level.WARNING, "language folder is not a directory!");
		}
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	private void log(String s) {
		Bukkit.getLogger().log(Level.WARNING, s);
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private void loadFiles() {
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
				keyedMap.put(currentLanguage.key(), currentLanguage);
			}
		}
	}

	public void load() {
		loadFiles();
	}

	public String getString(String key, String message) {
			if (keyedMap.containsKey(key)) {
				if (keyedMap.get(key).has(message)) {
					return keyedMap.get(key).message(message);
				}
			}
		return errorMessage.replace("%key%", key).replace("%message%", message);
	}

}
