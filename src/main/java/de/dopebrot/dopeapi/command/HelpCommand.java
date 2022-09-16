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
			if (!player.hasPermission(main.permissionBase + ".help.command")) {
				player.sendMessage(main.getString("command.permission"));
				return false;
			}
			player.sendMessage(main.getString("command.help.message"));
		}
		return false;
	}

	@Override
	public String[] getPermissions() {
		return new String[1];
	}
	@Override
	public String getCommandName() {
		return "dpapi-item-help";
	}
	@Override
	public void onDebug() {
		main.log(getCommandName() + main.getString("command.help.debug"));
	}

}
