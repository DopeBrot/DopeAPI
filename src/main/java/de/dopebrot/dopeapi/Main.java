package de.dopebrot.dopeapi;

import de.dopebrot.dopeapi.command.HelpCommand;
import de.dopebrot.dopeapi.command.TestCommand;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Level;

public class Main extends JavaPlugin {

	private HelpCommand helpCommand;
	private TestCommand testCommand;

	public final String permissionBase = "dp.itemapi";
	public ArrayList<DPCommand> commands;

	public void log(String s) {
		this.getLogger().log(Level.INFO, s);
	}

	public void onEnable() {
		registerCommands();
	}

	private void registerCommands() {
		commands.add(new HelpCommand(this));
		commands.add(new TestCommand(this));
		for (DPCommand command : commands) {
			this.getCommand(command.getCommandName()).setExecutor(command);
			log("registered command : " + command.getCommandName());
			for (String permission : command.getPermissions()) {
				log(" L> registered permission : " + permissionBase + permission);
			}
		}

	}

	public void onDisable() {

	}

}
