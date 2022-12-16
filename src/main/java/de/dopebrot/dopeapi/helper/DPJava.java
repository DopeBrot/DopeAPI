package de.dopebrot.dopeapi.helper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.net.URL;

public class DPJava {

	public static void downloadFile(URL url, File fileOut) throws IOException {
		try (InputStream in = url.openStream();
		     BufferedInputStream bIS = new BufferedInputStream(in);
		     FileOutputStream fOS = new FileOutputStream(fileOut)) {

			byte[] data = new byte[1024];
			int count;
			while ((count = bIS.read(data, 0, 1024)) != -1) {
				fOS.write(data, 0, count);
			}
		}
	}

	public static void getResourceFile(Plugin plugin, String fileName, File file) {
		InputStream inputStream = plugin.getResource(fileName);
		try {
			assert inputStream != null;
			FileUtils.copyInputStreamToFile(inputStream, file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Nullable
	public static BufferedReader getResourceFile(Plugin plugin, String fileName) {
		Validate.notNull(plugin);
		Validate.notEmpty(fileName);
		if (plugin.getResource(fileName) != null) {
			return new BufferedReader(new InputStreamReader(plugin.getResource(fileName)));

		}
		return null;
	}

}
