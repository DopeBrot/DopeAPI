package de.dopebrot.dopeapi.helper;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;

public class LanguageHelper {

	private Map<String, String> text;
	/**
	 * @param name represents the name of the file e.g (eng/de/it)
	 * @param path relative path to server eg (plugins/PLUGINNAME/lang)
	 */

	private final String name;
	private final String path;
	private final String prefix;
	private final YamlConfiguration yamlConfiguration;
	private final File file;
	private boolean debugLoad = false;
	private boolean isLoaded = false;

	public LanguageHelper(String name, String path, String prefix) {
		this.text = new LinkedHashMap<>();
		this.name = name;
		this.path = path;
		this.file = new File(this.path + "/" + this.name + ".yml");
		this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
		this.prefix = prefix;
	}

	public void debugLoad(boolean b) {
		debugLoad = b;
	}

	public void load() {
		if (!this.isLoaded) {
			this.isLoaded = true;
		}

		if (yamlConfiguration.contains(prefix)) {
			Bukkit.getLogger().log(Level.INFO, prefix + " exists");
		}

		Bukkit.getLogger().log(Level.INFO, "AAA: " + yamlConfiguration.getString("de.main_load"));

		List<String> list = yamlConfiguration.getConfigurationSection(prefix).getValues(false).keySet().stream().toList();
		for (String s : list) {
			Bukkit.getLogger().log(Level.INFO, "db : " + s + " val:" + yamlConfiguration.getString(s));
			text.put(s, yamlConfiguration.getString(prefix + "." + s));
		}
		if (debugLoad) {
			Bukkit.getLogger().log(Level.INFO, "language " + name + " was loaded");
		}

	}

	public String getString(String value) {
		Bukkit.getLogger().log(Level.INFO, "input before : " + value);
		value = value.replaceAll("\\.", "_");
		Bukkit.getLogger().log(Level.INFO, "input after : " + value);
		if (!isLoaded) {
			return "language is not loaded!";
		}

		String[] a = text.keySet().toArray(new String[0]);
		for (String s : a) {
			Bukkit.getLogger().log(Level.INFO, prefix + " lang:[" + s + "]");
		}

		if (text.containsKey(value)) {
			return text.get(value);
		}

		return "text [" + value + "] not found!";
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

	public void save() {
		if (!file.exists()) {
			try {
				file.createNewFile();
				save();
				return;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		try {
			yamlConfiguration.save(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
