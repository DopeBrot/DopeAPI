package de.dopebrot.dopeapi.helper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

public class LanguageHelper {

	private final Map<String, String> text;
	private final String name;
	private final String path;
	private final String prefix;
	private final YamlConfiguration yamlConfiguration;
	private final File file;
	private boolean usingPrefix = true;
	private boolean debug = false;
	private boolean isLoaded = false;
	private String errorString = "Error [$key$] was not found! report this to an Administrator";

	/**
	 * @param name   Name of the Language
	 * @param path   The path where the file is saved
	 * @param prefix prefix of language
	 * @apiNote if you use this, put it in a main and write a method that uses a message getter.
	 */
	public LanguageHelper(String name, String path, String prefix) {
		this.text = new LinkedHashMap<>();
		this.name = name;
		this.path = path;
		this.file = new File(this.path + "/" + this.name + ".yml");
		this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		this.prefix = prefix;
	}

	/**
	 * @param s new error message
	 * @apiNote add string "$key$" to get key name!
	 */
	public void setErrorString(String s) {
		errorString = s;
	}

	public void usingPrefix(boolean b) {
		usingPrefix = b;
	}

	/**
	 * @param b sets debug mode on or off
	 */
	public void setDebug(boolean b) {
		debug = b;
		if (debug) {
			Bukkit.getLogger().log(Level.INFO, "Language " + name + " debug messages will now appear");
		} else {
			Bukkit.getLogger().log(Level.INFO, "Language " + name + " debug messages will not appear anymore");
		}
	}

	/**
	 * loads the File in one Map
	 * on the first load {@code isLoaded} is set to true
	 */
	public void load() {
		if (isLoaded) {
			text.clear();
			try {
				this.yamlConfiguration.load(file);
			} catch (IOException | InvalidConfigurationException e) {
				if (debug) {
					Bukkit.getLogger().log(Level.WARNING,"language could not be reloaded:");
					Bukkit.getLogger().log(Level.WARNING,e.getMessage());
				}
			}
		}
		if (!this.isLoaded) {
			this.isLoaded = true;
		}

		if (yamlConfiguration.getConfigurationSection(prefix) != null) {
			Objects.requireNonNull(yamlConfiguration.getConfigurationSection(prefix)).getValues(false);
			List<String> list = yamlConfiguration.getConfigurationSection(prefix).getValues(false).keySet().stream().toList();
			for (String s : list) {
				String value = yamlConfiguration.getString(prefix + "." + s);
				assert value != null;
				text.put(s, value);
			}
			if (debug) {
				Bukkit.getLogger().log(Level.INFO, "Language [" + name + "] (" + prefix + ") was loaded");
			}
		}

	}

	/**
	 * @param key e.g. ("command.help.permission")
	 * @return String from key e.g. ("you can't access this command!")
	 */
	public String getString(String key) {
		Validate.notNull(key, "key can't be null!");
		Validate.notEmpty(key, "key can't be empty!");
		key = key.replaceAll("\\.", "_");
		if (!isLoaded) {
			Bukkit.getLogger().log(Level.WARNING, "Language [" + name + "] (" + prefix + ") is not loaded!");
		}
		if (text.containsKey(key)) {
			if (usingPrefix) {
				if (text.get(key).contains("$prefix$")) {
					return text.get(key).replace("$prefix$", text.get("prefix"));
				}
			}
			return text.get(key);
		}
		return errorString.replace("$key$", key);
	}

	/**
	 * @param key  key of text eg (command.help.error.permission)
	 * @param text value of key eg ("you don't have permission to use this command");
	 */
	public void setText(String key, String text) {
		setText(key, text, new String[]{});
	}

	/**
	 * @param key     key of text eg (command.help.error.permission)
	 * @param text    value of key eg ("you don't have permission to use this command");
	 * @param comment comment for editing the yml file // ("when a user has no permission for help command")
	 * @apiNote comment can be empty
	 */
	public void setText(String key, String text, String[] comment) {
		Validate.notNull(key, "key can't be null!");
		Validate.notEmpty(key, "key can't be empty!");
		Validate.notNull(text, "text can't be null!");
		Validate.notEmpty(text, "text can't be empty!");
		key = key.replaceAll("\\.", "_");
		yamlConfiguration.set(prefix + "." + key, text);
		if (comment.length > 0) {
			if (!comment[0].isEmpty()) {
				yamlConfiguration.setComments(prefix + "." + key, Arrays.stream(comment).toList());
			}
		}
	}

	/**
	 * saves file at path
	 *
	 * @throws RuntimeException when file can't be created
	 */
	public void save() {
		if (!file.exists()) {
			if (file.mkdirs()) {
				Bukkit.getLogger().log(Level.CONFIG, "create language dirs [" + name + "]");
			}
			try {
				if (file.createNewFile()) {
					Bukkit.getLogger().log(Level.CONFIG, "create language file [" + name + "]");
				}
				Bukkit.getLogger().log(Level.SEVERE, "Could not create language file");
				Bukkit.getLogger().log(Level.SEVERE, "path [" + path + name + ".yml]");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not save Language file");
			Bukkit.getLogger().log(Level.SEVERE, "path [" + path + name + ".yml]");
		}
	}

}
