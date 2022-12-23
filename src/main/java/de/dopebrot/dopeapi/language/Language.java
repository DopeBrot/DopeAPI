package de.dopebrot.dopeapi.language;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.dopebrot.dopeapi.config.DPConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;

/**
 * A default Language could look like this:<br>
 *<pre>
 * {@link #file} = "english.json"
 * {@link #key} = "en"
 * {@link #name} = "english"</pre>
 * A {@link Language} defines {@link #key} for example "player.disconnect" and {@link #messages} "%0% disconnected!"<br>
 * every {@link Language} has its own {@link File}, {@link DPConfig}. <br>
 * you can check if the language has a key
 *
 */

public class Language {

	private final File file;
	private final DPConfig config;
	private final HashMap<String, String> messages;
	private String key;
	private String name;

	/**
	 * creates a new language
	 *
	 * @param file   which file is this language
	 * @param config which config is controlled over it
	 */
	public Language(File file, DPConfig config) {
		this.file = file;
		this.config = config;
		this.key = config.jsonObject().getAsJsonObject("language").getAsJsonPrimitive("key").getAsString();
		this.name = config.jsonObject().getAsJsonObject("language").getAsJsonPrimitive("name").getAsString();
		this.messages = new HashMap<>();
		if (key.isEmpty()) {
			key = "null";
		}
		if (name.isEmpty()) {
			name = "null";
		}
	}

	/**
	 * file where everything is stored
	 */
	@NotNull
	public File file() {
		return file;
	}

	/**
	 * configuration in json
	 */
	@NotNull
	public DPConfig config() {
		return config;
	}

	/**
	 * key that need be called (en)
	 */
	@NotNull
	public String key() {
		return this.key;
	}

	/**
	 * name of the language (english)
	 */
	@NotNull
	public String name() {
		return name;
	}

	/**
	 * loads whole file in memory
	 */
	public void load() {
		JsonObject languageConfig = config.jsonObject().getAsJsonObject("language");

		if (languageConfig.has("key")) {
			if (languageConfig.get("key").isJsonPrimitive()) {
				key = languageConfig.getAsJsonPrimitive("key").getAsString();
			}
		}

		if (languageConfig.has("name")) {
			if (languageConfig.get("name").isJsonPrimitive()) {
				name = languageConfig.getAsJsonPrimitive("name").getAsString();
			}
		}

		if (languageConfig.has("messages")) {
			JsonArray messageArray = languageConfig.getAsJsonArray("messages");
			if (!messageArray.isEmpty()) {
				for (int i = 0; i < messageArray.size(); i++) {
					if (messageArray.get(i).isJsonObject()) {
						JsonObject messageObject = messageArray.get(i).getAsJsonObject();
						if (messageObject.has("key") && messageObject.has("message")) {
							if (messageObject.get("key").isJsonPrimitive() && messageObject.get("message").isJsonPrimitive()) {
								messages.put(messageObject.getAsJsonPrimitive("key").getAsString(), messageObject.getAsJsonPrimitive("message").getAsString());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * unloads the Language to save Memory
	 */
	public void unload() {
		JsonObject languageConfig = new JsonObject();
		messages.clear();
	}


	public boolean has(String message) {
		return messages.containsKey(message);
	}

	@Nullable
	public String message(String key) {
		return messages.get(key);
	}

	@NotNull
	public HashMap<String, String> getMessages() {
		return messages;
	}

}
