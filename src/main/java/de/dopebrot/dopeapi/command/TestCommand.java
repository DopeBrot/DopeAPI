package de.dopebrot.dopeapi.command;
import de.dopebrot.dopeapi.helper.DPCommand;
import de.dopebrot.dopeapi.DPItem;
import de.dopebrot.dopeapi.Main;
import de.dopebrot.dopeapi.helper.DPColor;
import de.dopebrot.dopeapi.helper.DPEnchantment;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements DPCommand {

	private final Main main;

	public TestCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player player) {
			if (!player.hasPermission(main.permissionBase + ".dev.test")) {
				player.sendMessage(main.getString("command.permission"));
				return false;
			}

			player.getInventory().addItem(new DPItem().setDisplayName(new DPItem().getHead("DopeBrot"), main.getString("command.test.itemname.head")));
			player.getInventory().addItem(new DPItem().setDisplayName(new DPItem().setEnchantment(new DPItem().addFlag(new ItemStack(Material.BONE), new ItemFlag[]{ItemFlag.HIDE_ENCHANTS}), new Enchantment[]{DPEnchantment.KNOCKBACK.enchantment}, new int[]{16}), main.getString("command.test.itemname.bone")));
			player.getInventory().addItem(new DPItem().addAmount(new ItemStack(Material.GLOWSTONE, 1), 13));
			player.getInventory().addItem(new DPItem().addLore(new DPItem().setLore(new ItemStack(Material.PAPER), new String[]{DPColor.CHAT_RED.getPrefix() + main.getString("command.test.itemlore.line0"), DPColor.CHAT_BLUE.getPrefix() + main.getString("command.test.itemlore.line1"), DPColor.CHAT_YELLOW.getPrefix() + main.getString("command.test.itemlore.line2")}), new String[]{DPColor.CHAT_GREEN.getPrefix() + main.getString("command.test.itemlore.addedline")}, 2));
			ItemStack canAddItemStack = new DPItem().setDisplayName(new ItemStack(Material.STICK, 1), "checker if this item can be added to your inventory");
			if (new DPItem().canAddItem(player.getInventory(), canAddItemStack)) {
				player.sendMessage(main.getString("command.test.item.canadd"));
				player.getInventory().addItem(canAddItemStack);
			} else {
				player.sendMessage(main.getString("command.test.item.cantadd"));
			}
			player.sendMessage(DPColor.CHAT_GOLD.getPrefix() + DPColor.CHAT_UNDERLINE.getPrefix() + main.getString("command.test.colormessage0"));
			player.sendMessage(DPColor.CHAT_RED.getPrefix() + DPColor.CHAT_ITALIC.getPrefix() + main.getString("command.test.colormessage1"));
			return true;
		}
		return false;
	}

	@Override
	public String[] getPermissions() {
		return new String[]{".dev.test"};
	}
	@Override
	public String getCommandName() {
		return "dpapi-item-test";
	}
	@Override
	public void onDebug() {
		main.log(getCommandName() + main.getString("command.test.debug"));
	}

}
