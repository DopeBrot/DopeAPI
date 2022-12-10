package de.dopebrot.dopeapi.language;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.dopebrot.dopeapi.config.DPConfig;

import java.io.File;
import java.util.HashMap;

public class Language {

	private final File file;
	private final DPConfig config;
	private final HashMap<String, String> messages;
	private String key;
	private String name;
	public Language(File file, DPConfig config) {
		this.file = file;
		this.config = config;
		this.key = config.getJsonObject().getAsJsonObject("language").getAsJsonPrimitive("key").getAsString();
		this.name = config.getJsonObject().getAsJsonObject("language").getAsJsonPrimitive("name").getAsString();
		this.messages = new HashMap<>();
		if (key.isEmpty()) {
			key = "null";
		}
		if (name.isEmpty()) {
			name = "null";
		}
	}

	public File file() {
		return file;
	}

	public DPConfig config() {
		return config;
	}

	public String key() {
		return this.key;
	}

	public String name() {
		return name;
	}

	public void load() {
		JsonObject languageConfig = config.getJsonObject().getAsJsonObject("language");

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

	public boolean has(String message) {
		return messages.containsKey(message);
	}

	public String message(String key) {
		return messages.get(key);
	}

	public HashMap<String, String> getMessages() {
		return messages;
	}

}
