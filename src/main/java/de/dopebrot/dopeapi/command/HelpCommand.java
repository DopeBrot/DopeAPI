package de.dopebrot.dopeapi.command;
import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpCommand implements DPCommand {

	private final Main main;

	public HelpCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player player) {
			if (player.hasPermission(main.permissionBase + ".help.command")) {
				player.sendMessage("§c[ItemAPI]§r > This plugin was made to simplify development.");
			}
		}
		return false;
	}

	@Override
	public String[] getPermissions() {
		return new String[1];
	}
	@Override
	public String getCommandName() {
		return "DP-itemhelp";
	}
	@Override
	public void onDebug() {
		main.log(getCommandName() + " is working fine");
	}

}
