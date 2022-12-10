package de.dopebrot.dopeapi.config;
import com.google.gson.*;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Map;

public class DPConfig {

	private final Gson gson;
	private final File file;
	private JsonObject jsonObject;

	// if it can't find the file it'll use an empty json object.

	public DPConfig(File file, boolean load) {
		Validate.notNull(file);
		this.file = file;
		this.jsonObject = new JsonObject();
		this.gson = new Gson();
		if (load) {
			try {
				this.jsonObject = gson.fromJson(new FileReader(file), JsonObject.class);
			} catch (FileNotFoundException ignored) {
			}
		}
	}

	public void setString(String path, String s) {
		if (!isValid(path)) {
			return;
		}
		Validate.notNull(s, "String can't be null");
		Validate.notEmpty(s, "String can't be empty");
		jsonObject.addProperty(path, s);
	}

	public void setNumber(String path, Number n) {
		if (!isValid(path)) {
			return;
		}

		Validate.notNull(n);
		jsonObject.addProperty(path, n);
	}

	public void setChar(String path, char c) {
		if (!isValid(path)) {
			return;
		}

		jsonObject.addProperty(path, c);
	}

	public void setBoolean(String path, boolean b) {
		if (!isValid(path)) {
			return;
		}

		jsonObject.addProperty(path, b);
	}

	public void setElement(String path, JsonElement element) {
		if (!isValid(path)) {
			return;
		}
		Validate.notNull(element, "element can't be null");
		jsonObject.add(path, element);
	}

	public void setLocation(String path, Location location) {
		Validate.notNull(location, "location can't be null");
		if (!isValid(path)) {
			return;
		}
		Map<String, Object> loc = location.serialize();
		String worldName = (String) loc.get("world");
		double x = (double) loc.get("x");
		double y = (double) loc.get("y");
		double z = (double) loc.get("z");
		float yaw = (float) loc.get("yaw");
		float pitch = (float) loc.get("pitch");
		setString(path + ".w", worldName);
		setNumber(path + ".x", x);
		setNumber(path + ".y", y);
		setNumber(path + ".z", z);
		setNumber(path + ".yaw", yaw);
		setNumber(path + ".pitch", pitch);
	}

	@Nullable
	public Location getLocation(String path) {
		if (!isValid(path)) {
			return null;
		}
		World w = Bukkit.getWorld(getString(path + ".w"));
		int x = getNumber(path + ".x").intValue();
		int y = getNumber(path + ".y").intValue();
		int z = getNumber(path + ".z").intValue();
		float yaw = getNumber(path + ".yaw").floatValue();
		float pitch = getNumber(path + ".pitch").floatValue();
		return new Location(w, x, y, z, yaw, pitch);
	}

	public void setItemStack(String path, ItemStack itemStack) {
		if (!isValid(path)) {
			return;
		}
		Validate.notNull(itemStack, "itemstack can't be null");
		Map<String, Object> item = itemStack.serialize();
		setNumber(path + ".version", (int) item.get("v"));
		setString(path + ".type", (String) item.get("type"));
		setNumber(path + ".amount", (int) item.get("amount"));
		// TODO: itemMeta
	}

	@Nullable
	public ItemStack getItemStack(String path) {
		if (!isValid(path)) {
			return null;
		}
		int version = getNumber(path + ".version").intValue();
		String type = getString(path + ".type");
		int amount = getNumber(path + "amount").intValue();
		if (Material.getMaterial(type) != null) {
			return new ItemStack(Material.getMaterial(type), amount);
		}
		return null;
	}

	public boolean isValid(String path) {
		Validate.notNull(path, "path can't be null");
		Validate.notEmpty(path, "path can't be empty");
		return jsonObject.has(path);
	}

	public boolean isArray(String path) {
		return (isValid(path) && jsonObject.get(path).isJsonArray());
	}

	public boolean isElement(String path) {
		return (isValid(path) && !jsonObject.isJsonNull());
	}

	public boolean isObject(String path) {
		return (isValid(path) && jsonObject.get(path).isJsonObject());
	}

	public boolean isPrimitive(String path) {
		return (isValid(path) && jsonObject.get(path).isJsonPrimitive());
	}

	public JsonElement getElement(String path) {
		isValid(path);
		return jsonObject.get(path);
	}

	public Number getNumber(String path) {
		return ((JsonPrimitive) getElement(path)).getAsNumber();
	}

	public String getString(String path) {
		return ((JsonPrimitive) getElement(path)).getAsString();
	}

	public boolean getBoolean(String path) {
		return ((JsonPrimitive) getElement(path)).getAsBoolean();
	}

	public JsonArray getArray(String path) {
		return (JsonArray) getElement(path);
	}

	public JsonObject getJsonObject() {
		return this.jsonObject;
	}

	public Gson getGson() {
		return this.gson;
	}

	public void save() {
		try {
			FileWriter fileWriter = new FileWriter(file);
			gson.toJson(jsonObject, fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public DPConfigBuilder builder() {
		return new DPConfigBuilder(this);
	}

}