package de.dopebrot.dopeapi.config;
import com.google.gson.JsonElement;

public class DPConfigBuilder {

	private final DPConfig dpConfig;

	public DPConfigBuilder(DPConfig dpConfig) {
		this.dpConfig = dpConfig;
	}

	public DPConfigBuilder addNumber(String path, Number n) {
		dpConfig.setNumber(path, n);
		return this;
	}

	public DPConfigBuilder addString(String path, String s) {
		dpConfig.setString(path, s);
		return this;
	}

	public DPConfigBuilder addChar(String path, char c) {
		dpConfig.setChar(path, c);
		return this;
	}

	public DPConfigBuilder addBoolean(String path, boolean b) {
		dpConfig.setBoolean(path,b);
		return this;
	}

	public DPConfigBuilder addElement(String path, JsonElement element) {
		dpConfig.setElement(path,element);
		return this;
	}


	public void build() {}

}
