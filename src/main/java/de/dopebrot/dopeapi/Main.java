package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.command.HelpCommand;
import de.dopebrot.dopeapi.command.TestCommand;
import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.helper.LanguageHelper;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private HelpCommand helpCommand;
	private TestCommand testCommand;
	private LanguageHelper languageHelper;

	public final String permissionBase = "dp.itemapi";
	public ArrayList<DPCommand> commands;

	public void log(String s) {
		this.getLogger().log(Level.INFO, s);
	}

	public void onEnable() {
		registerCommands();
		languageHelper = new LanguageHelper("deutsch", "plugins/DPAPI/lang", "de");
		languageHelper.setText("main.load","test");
		languageHelper.save();
		log(languageHelper.getString("main.load"));
		languageHelper.debugLoad(true);
		languageHelper.load();
		log(languageHelper.getString("main.load"));
		languageHelper.setText("test.kaese","dies ist eine test nachricht für kommentare",new String[]{"Comment 1","Comment 2"});
		languageHelper.save();
	}

	private void registerCommands() {
	}

	public void onDisable() {

	}

}
