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
			if (player.hasPermission(main.permissionBase + ".dev.test")) {
				player.getInventory().addItem(new DPItem().setDisplayName(new DPItem().getHead("DopeBrot"), "§a[§bT§ce§ds§et§r]"));
				player.getInventory().addItem(new DPItem().setDisplayName(new DPItem().setEnchantment(new DPItem().addFlag(new ItemStack(Material.BONE), new ItemFlag[]{ItemFlag.HIDE_ENCHANTS}), new Enchantment[]{DPEnchantment.KNOCKBACK.enchantment}, new int[]{16}), "Bone with hidden Knockback enchantment level 1"));
				player.getInventory().addItem(new DPItem().addAmount(new ItemStack(Material.GLOWSTONE, 1), 13));
				player.getInventory().addItem(new DPItem().addLore(new DPItem().setLore(new ItemStack(Material.PAPER), new String[]{DPColor.CHAT_RED.getPrefix() + "this is line 1 red", DPColor.CHAT_BLUE.getPrefix() + "this is line 2 blue", DPColor.CHAT_YELLOW.getPrefix() + "and line 3 yellow"}), new String[]{DPColor.CHAT_GREEN.getPrefix() + "green added line to line 3"}, 2));
				ItemStack canAddItemStack = new DPItem().setDisplayName(new ItemStack(Material.STICK, 1), "checker if this item can be added to your inventory");
				if (new DPItem().canAddItem(player.getInventory(), canAddItemStack)) {
					player.sendMessage("item can be added");
					player.getInventory().addItem(canAddItemStack);
				} else {
					player.sendMessage("item cant be added");
				}
				player.sendMessage(DPColor.CHAT_GOLD.getPrefix() + DPColor.CHAT_UNDERLINE.getPrefix() + "this message is in gold and underlined");
				player.sendMessage(DPColor.CHAT_RED.getPrefix() + DPColor.CHAT_ITALIC.getPrefix() + "this message is in red and italic");
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getPermissions() {
		return new String[]{".dev.test"};
	}
	@Override
	public String getCommandName() {
		return "itemapi-test";
	}
	@Override
	public void onDebug() {
		main.log(getCommandName() + " is working fine");
	}

}
