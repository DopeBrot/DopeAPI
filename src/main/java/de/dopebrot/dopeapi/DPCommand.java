package de.dopebrot.dopeapi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface DPCommand extends CommandExecutor {

	public String[] getPermissions();
	public String getCommandName();

}
