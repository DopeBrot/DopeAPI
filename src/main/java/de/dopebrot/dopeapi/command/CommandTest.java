package de.dopebrot.dopeapi.command;
import de.dopebrot.dopeapi.DPCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandTest implements DPCommand {

	@Override
	public String[] getPermissions() {
		return new String[0];
	}
	@Override
	public String getCommandName() {
		return null;
	}
	@Override
	public boolean playerOnly() {
		return false;
	}
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		return false;
	}

}
