package de.dopebrot.dopeapi;

import net.kyori.adventure.text.Component;
import org.apache.commons.lang.Validate;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.logging.Level;

public class DPItem {

	/**
	 * @param playerName the name of the player wich the skull should be
	 * @return itemstack of skull
	 */
	public ItemStack getHead(String playerName) {
		Validate.notNull(playerName, "playerName can't be null!");
		ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
		if (itemStack.getItemMeta() instanceof SkullMeta skullMeta) {
			skullMeta.setOwningPlayer(new OfflinePlayer() {

				@Override
				public boolean isOnline() {
					return false;
				}
				@Override
				public @Nullable String getName() {
					return playerName;
				}
				@Override
				public @NotNull UUID getUniqueId() {
					return null;
				}
				@Override
				public @NotNull PlayerProfile getPlayerProfile() {
					return null;
				}
				@Override
				public boolean isBanned() {
					return false;
				}
				@Override
				public boolean isWhitelisted() {
					return false;
				}
				@Override
				public void setWhitelisted(boolean value) {

				}
				@Override
				public @Nullable Player getPlayer() {
					return null;
				}
				@Override
				public long getFirstPlayed() {
					return 0;
				}
				@Override
				public long getLastPlayed() {
					return 0;
				}
				@Override
				public boolean hasPlayedBefore() {
					return false;
				}
				@Override
				public @Nullable Location getBedSpawnLocation() {
					return null;
				}
				@Override
				public long getLastLogin() {
					return 0;
				}
				@Override
				public long getLastSeen() {
					return 0;
				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {

				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic, int amount) throws IllegalArgumentException {

				}
				@Override
				public void setStatistic(@NotNull Statistic statistic, int newValue) throws IllegalArgumentException {

				}
				@Override
				public int getStatistic(@NotNull Statistic statistic) throws IllegalArgumentException {
					return 0;
				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {

				}
				@Override
				public int getStatistic(@NotNull Statistic statistic, @NotNull Material material) throws IllegalArgumentException {
					return 0;
				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic, @NotNull Material material, int amount) throws IllegalArgumentException {

				}
				@Override
				public void setStatistic(@NotNull Statistic statistic, @NotNull Material material, int newValue) throws IllegalArgumentException {

				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {

				}
				@Override
				public int getStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType) throws IllegalArgumentException {
					return 0;
				}
				@Override
				public void incrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) throws IllegalArgumentException {

				}
				@Override
				public void decrementStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int amount) {

				}
				@Override
				public void setStatistic(@NotNull Statistic statistic, @NotNull EntityType entityType, int newValue) {

				}
				@Override
				public @NotNull Map<String, Object> serialize() {
					return null;
				}
				@Override
				public boolean isOp() {
					return false;
				}
				@Override
				public void setOp(boolean value) {

				}
			});
			itemStack.setItemMeta(skullMeta);
		}
		return itemStack;
	}

	/**
	 * @param itemStack   itemstack where the name should change.
	 * @param displayName name of the itemstack
	 * @return changed itemstack
	 */
	public ItemStack setDisplayName(ItemStack itemStack, String displayName) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		Validate.notNull(displayName, "displayname can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.displayName(Component.text(displayName));
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack which displayname should be getted
	 * @return Component displayname name
	 */
	public Component getDisplayName(ItemStack itemStack) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		if (itemStack.hasItemMeta()) {
			if (itemStack.getItemMeta().displayName() != null) {
				return itemStack.getItemMeta().displayName();
			}
		}
		return Component.text("");
	}

	/**
	 * @param inventory inventory wich the itemstack will be added
	 * @param itemStack itemstack wich will be added to inventory
	 * @return true if the itemstack will fit in the inventory
	 */
	public boolean canAddItem(Inventory inventory, ItemStack itemStack) {
		Validate.notNull(inventory, "inventory can't be null!");
		Validate.notNull(itemStack, "itemstack can't be null!");
		if (inventory.isEmpty())
			return true;
		for (ItemStack is : inventory.getContents()) {
			if (is == null) {
				return true;
			}
		}
		for (ItemStack is : inventory.getContents()) {
			if (is != null) {
				if (is.isSimilar(itemStack) && is.getAmount() + is.getAmount() <= 64) {
					return true;
				}
			}
		}
		int temp = itemStack.getAmount();
		for (ItemStack is : inventory.getContents()) {
			if (is != null) {
				if (is.isSimilar(itemStack)) {
					if (is.getAmount() < 64) {
						temp -= (64 - is.getAmount());
					}
				}
			}
		}
		if (temp == 0) {
			return true;
		}

		return false;
	}

	/**
	 * @param itemStack itemstack which amount should be getted
	 * @return itemstack amount
	 */
	public int getAmount(ItemStack itemStack) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		return itemStack.getAmount();
	}

	/**
	 * @param itemStack itemstack wich amount gets set
	 * @param amount    the amount the itemstack will have
	 * @return changed itemstack
	 */
	public ItemStack setAmount(ItemStack itemStack, int amount) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		Validate.isTrue(amount < 1, "amount must be positive");
		itemStack.setAmount(amount);
		return itemStack;
	}

	/**
	 * @param itemStack itemstack wich amount gets added
	 * @param amount    the amount the itemstack will add
	 * @return changed itemstack
	 */
	public ItemStack addAmount(ItemStack itemStack, int amount) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		Validate.isTrue(amount > 1, "amount must be positive");
		if (amount + itemStack.getAmount() > 64) {
			itemStack.setAmount(64);
			return itemStack;
		}
		if (itemStack.getAmount() + amount < 1) {
			itemStack.setAmount(1);
			return itemStack;
		}
		itemStack.setAmount(itemStack.getAmount() + amount);
		return itemStack;
	}

	/**
	 * @param itemStack itemstack wich amount gets removed
	 * @param amount    the amount the itemstack will remove
	 * @return changed itemstack
	 */
	public ItemStack removeAmount(ItemStack itemStack, int amount) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		Validate.isTrue(amount >= 1, "amount must be positive");
		if (itemStack.getAmount() - amount > 64) {
			itemStack.setAmount(64);
			return itemStack;
		}
		if (itemStack.getAmount() - amount < 1) {
			itemStack.setAmount(1);
			return itemStack;
		}
		itemStack.setAmount(itemStack.getAmount() + amount);
		return itemStack;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param lore      the lore which will be setted
	 * @return lore changed itemstack
	 */
	public ItemStack setLore(ItemStack itemStack, String[] lore) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(lore, "lore can't be null!");
		Validate.noNullElements(lore, "lore can't have null!");
		ArrayList<Component> componentArrayList = new ArrayList<>();
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			for (String s : lore) {
				componentArrayList.add(Component.text(s));
			}
			itemMeta.lore(componentArrayList);
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack which lore should be getted
	 * @return Component list of itemStack lore
	 */
	public List<Component> getLore(ItemStack itemStack) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		if (itemStack.hasItemMeta()) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (itemMeta.hasLore()) {
				return itemMeta.lore();
			}
		}
		return new ArrayList<>() {};
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param lore      the lore which will be added
	 * @param position  position where the lore will be added
	 * @return lore changed itemstack
	 */
	public ItemStack addLore(ItemStack itemStack, String[] lore, int position) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(lore, "lore can't be null!");
		Validate.noNullElements(lore, "lore can't have null!");
		ArrayList<Component> componentArrayList = new ArrayList<>();
		ArrayList<Component> newlore = new ArrayList<>();
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (itemMeta.hasLore()) {
				componentArrayList.addAll(itemMeta.lore());
				for (String s : lore) {
					newlore.add(Component.text(s));
				}
				componentArrayList.addAll(position, newlore);
			} else {
				return setLore(itemStack, lore);
			}
			itemMeta.lore(componentArrayList);
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param position  position where the lore will be added
	 * @return lore changed itemstack
	 */
	public ItemStack removeLore(ItemStack itemStack, int position) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (!itemMeta.hasLore()) {
				Bukkit.getLogger().log(Level.WARNING, "itemStack has no lore");
				return null;
			}
			ArrayList<Component> componentArrayList = new ArrayList<>(Objects.requireNonNull(itemMeta.lore()));
			componentArrayList.remove(position);
			itemMeta.lore(componentArrayList);
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param flag      itemflag which will be setted
	 * @return itemstack with setted flag/s
	 */
	public ItemStack setFlag(ItemStack itemStack, ItemFlag[] flag) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(flag, "flag can't be null!");
		Validate.noNullElements(flag, "flags can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			for (ItemFlag itemFlag : itemMeta.getItemFlags()) {
				itemMeta.removeItemFlags(itemFlag);
			}
			for (ItemFlag itemFlag : flag) {
				itemMeta.addItemFlags(itemFlag);
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param flag      itemflag which will be added
	 * @return itemstack with added flag/s
	 */
	public ItemStack addFlag(ItemStack itemStack, ItemFlag[] flag) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(flag, "flag can't be null!");
		Validate.noNullElements(flag, "flags can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			for (ItemFlag itemFlag : flag) {
				if (!itemMeta.getItemFlags().contains(itemFlag)) {
					itemMeta.addItemFlags(itemFlag);
				}
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @param flag      itemflag/s which will be removed
	 * @return itemstack with added flag/s
	 */
	public ItemStack removeFlag(ItemStack itemStack, ItemFlag[] flag) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(flag, "flag can't be null!");
		Validate.noNullElements(flag, "flags can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			for (ItemFlag itemFlag : flag) {
				if (itemMeta.getItemFlags().contains(itemFlag)) {
					itemMeta.removeItemFlags(itemFlag);
				}
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack which flags should be getted
	 * @return ItemFlags flags from itemstack or null if itemstack has no flags
	 */
	public Set<ItemFlag> getFlags(ItemStack itemStack) {
		Validate.notNull(itemStack, "itemstack can't be null!");
		if (itemStack.hasItemMeta()) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (!itemMeta.getItemFlags().isEmpty()) {
				return itemMeta.getItemFlags();
			}
		}
		return null;
	}

	/**
	 * @param itemStack   itemstack with lore change
	 * @param enchantment enchantment/s which will be added
	 * @param level       enchantment/s level
	 * @return itemstack with added enchantment/s
	 */
	public ItemStack addEnchantment(ItemStack itemStack, Enchantment[] enchantment, int[] level) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(enchantment, "enchantment can't be null!");
		Validate.noNullElements(enchantment, "enchantments can't contain null!");
		if (enchantment.length != level.length) {
			Bukkit.getLogger().log(Level.WARNING, "enchantment length doesn't fit enchantment level");
		}
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			for (int e = 0; e < enchantment.length; e++) {
				itemMeta.addEnchant(enchantment[e], level[e], true);
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack   itemstack with lore change
	 * @param enchantment enchantment/s which will be setted
	 * @param level       enchantment/s level
	 * @return itemstack with setted enchantment/s
	 */
	public ItemStack setEnchantment(ItemStack itemStack, Enchantment[] enchantment, int[] level) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(enchantment, "enchantment can't be null!");
		Validate.noNullElements(enchantment, "enchantments can't contain null!");
		if (enchantment.length != level.length) {
			Bukkit.getLogger().log(Level.WARNING, "enchantment length doesn't fit enchantment level");
		}
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (!itemMeta.getEnchants().isEmpty()) {
				itemMeta.getEnchants().clear();
			}
			for (int e = 0; e < enchantment.length; e++) {
				itemMeta.addEnchant(enchantment[e], level[e], true);
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack   itemstack with lore change
	 * @param enchantment enchantment/s which will be removed
	 * @return itemstack with removed enchantment/s
	 */
	public ItemStack removeEnchantment(ItemStack itemStack, Enchantment[] enchantment) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		Validate.notNull(enchantment, "enchantment can't be null!");
		Validate.noNullElements(enchantment, "enchantments can't contain null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (!itemMeta.getEnchants().isEmpty()) {
				for (Enchantment ench : enchantment) {
					itemMeta.getEnchants().remove(ench);
				}
			}
			itemStack.setItemMeta(itemMeta);
			return itemStack;
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

	/**
	 * @param itemStack itemstack with lore change
	 * @return enchantments from itemstack
	 */
	public Set<Enchantment> getEnchantments(ItemStack itemStack) {
		Validate.notNull(itemStack, "itemStack can't be null!");
		if (itemStack.getItemMeta() != null) {
			ItemMeta itemMeta = itemStack.getItemMeta();
			if (itemMeta.hasEnchants()) {
				return itemMeta.getEnchants().keySet();
			}
		}
		Bukkit.getLogger().log(Level.WARNING, "itemStack has no itemMeta");
		return null;
	}

}
