package de.dopebrot.dopeapi.language;

import de.dopebrot.dopeapi.config.DPConfig;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;

/**
 * Language Manager<br>
 * loads <i>.json</i> {@link File} from a folder.<br>
 * the design should look like this.<br>
 * <pre>
 *     {"language": {
 *         "key":"en",
 *         "name":"english",
 *         "messages":[{"key":"player.disconnect", "message":"%0% disconnected!"}]
 *         }
 *     }</pre>
 * to get a message you first <i>need</i> to {@link #load()}<br>
 * the manager searches the folder {@link #languageFolder} for {@link File} that contains ".json".<br>
 * those {@link File} will be checked if they have the <i>"language":</i> tag<br>
 * from there you should set a {@link #setDefaultLanguageKey(String)} in my case this would be "en".<br>
 * from there you can call {@link #getString(String, String)} the first {@link String} is the <b>Language Key</b> en for English<br>
 * the second {@link String} is the <b>Message Key</b> for example "player.disconnect".<br>
 * this would return "%0% disconnected!" %0% is a placeholder like <i>%0%</i>,<i>%1%</i> for the player name,
 * but you can put anything in there.<br>
 * @version 2.0
 * @since 6.0
 * @see Language
 * @see DPConfig
 * @author DopeBrot
 */

public class LanguageManager {

	private final File languageFolder;
	private final ArrayList<Language> languages;
	private final HashMap<String, Language> languageIdentifier;
	private String errorMessage;
	private String defaultLanguageKey = "null";

	/**
	 * creates a new Language Manager
	 *
	 * @param folder where are all the language configs saved
	 * @author DopeBrot
	 * @apiNote all files in this directory need to be an "*.json"
	 * @since 6.0
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
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
	 * logs messages in console
	 *
	 * @param s String that is written
	 * @author DopeBrot
	 * @since 6.0
	 */
	private void log(String s) {
		Validate.notEmpty(s);
		Bukkit.getLogger().log(Level.WARNING, s);
	}

	/**
	 * sets the error message if the message is not found
	 *
	 * @param errorMessage string of the new message
	 * @author DopeBrot
	 * @since 6.0
	 */
	public void setErrorMessage(String errorMessage) {
		Validate.notEmpty(errorMessage);
		this.errorMessage = errorMessage;
	}

	/**
	 * @apiNote gets all files from language folder and puts them in memory.
	 * @author DopeBrot
	 * @since 6.0
	 */
	public void load() {
		if (languageFolder != null) {
			if (languageFolder.isDirectory()) {
				if (languageFolder.listFiles() != null) {
					for (File currentFile : Objects.requireNonNull(languageFolder.listFiles())) {
						if (currentFile != null) {
							if (currentFile.getName().toLowerCase().contains(".json")) {
								DPConfig tmpConfig = new DPConfig(currentFile, true);
								if (tmpConfig.jsonObject().has("language")) {
									Language language = new Language(currentFile, tmpConfig);
									language.load();
									this.languages.add(language);
								}
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
	 * @param message the message that is searched (message could be "player.disconnect")
	 * @return message from {@link #languages} if there is no language it will return {@link #errorMessage}
	 * @author DopeBrot
	 * @since 6.0
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
	 * @author DopeBrot
	 * @since 6.0
	 */
	public void setDefaultLanguageKey(String key) {
		Validate.notEmpty(key);
		if (!languageIdentifier.containsKey(key)) {
			Bukkit.getLogger().log(Level.WARNING, "default key > " + key + " couldn't be found and will not be set as default");
			return;
		}
		this.defaultLanguageKey = key;
	}

	/**
	 * @param key the key of the language that need to be found
	 * @return <b>true</b> if language was found, <b>false</b> if not
	 * @author DopeBrot
	 * @since 6.0
	 */
	public boolean hasLanguage(String key) {
		Validate.notEmpty(key);
		return languageIdentifier.containsKey(key);
	}

	/**
	 * @return {@link #languages}
	 * @author DopeBrot
	 * @since 6.0
	 */
	public ArrayList<Language> getLanguages() {
		return languages;
	}

	/**
	 * @return {@link #languageIdentifier}
	 * @author DopeBrot
	 * @since 6.0
	 */
	public HashMap<String, Language> getLanguageIdentifier() {
		return languageIdentifier;
	}

}
