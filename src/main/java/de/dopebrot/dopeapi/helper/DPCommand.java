package de.dopebrot.dopeapi.helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface DPCommand extends CommandExecutor {

	/**
		which permission the command has.
	 */
	public String[] getPermissions();
	/**
	    command name.
	 */
	public String getCommandName();
	/**
		check if command is working.
	 */
	public void onDebug();
}
