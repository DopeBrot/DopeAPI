package de.dopebrot.dopeapi.helper;
import org.bukkit.enchantments.Enchantment;

public enum DPEnchantment {

	PROTECTION(Enchantment.PROTECTION_ENVIRONMENTAL, 0, "protection"),
	FIRE_PROTECTION(Enchantment.PROTECTION_FIRE, 1, "fire_protection"),
	FEATHER_FALLING(Enchantment.PROTECTION_FALL, 2, "feather_falling"),
	BLAST_PROTECTION(Enchantment.PROTECTION_EXPLOSIONS, 3, "blast_protection"),
	PROJECTILE_PROTECTION(Enchantment.PROTECTION_PROJECTILE, 4, "projectile_protection"),
	RESPIRATION(Enchantment.OXYGEN, 5, "respiration"),
	AQUA_AFFINITY(Enchantment.WATER_WORKER, 6, "aqua_affinity"),
	THORNS(Enchantment.THORNS, 7, "thorns"),
	DEPTH_STRIDER(Enchantment.DEPTH_STRIDER, 8, "depth_strider"),
	FROST_WALKER(Enchantment.FROST_WALKER, 9, "frost_walker"),
	CURSE_OF_BINDING(Enchantment.BINDING_CURSE, 10, "binding_curse"),
	SHARPNESS(Enchantment.DAMAGE_ALL, 16, "sharpness"),
	SMITE(Enchantment.DAMAGE_UNDEAD, 17, "smite"),
	BANE_OF_ARTHROPODS(Enchantment.DAMAGE_UNDEAD, 18, "bane_of_arthropods"),
	KNOCKBACK(Enchantment.KNOCKBACK, 19, "knockback"),
	FIRE_ASPECT(Enchantment.FIRE_ASPECT, 20, "fire_aspect"),
	LOOTING(Enchantment.LOOT_BONUS_MOBS, 21, "looting"),
	SWEEPING_EDGE(Enchantment.SWEEPING_EDGE, 22, "sweeping_edge"),
	EFFICIENCY(Enchantment.DIG_SPEED, 32, "efficiency"),
	SILK_TOUCH(Enchantment.SILK_TOUCH, 33, "silk_touch"),
	UNBREAKING(Enchantment.DURABILITY, 34, "unbreaking"),
	FORTUNE(Enchantment.LOOT_BONUS_BLOCKS, 35, "fortune"),
	POWER(Enchantment.ARROW_DAMAGE, 48, "power"),
	PUNCH(Enchantment.ARROW_KNOCKBACK,49,"punch"),
	FLAME(Enchantment.ARROW_FIRE,50,"flame"),
	INFINITY(Enchantment.ARROW_INFINITE,51,"infinity"),
	LUCK_OF_THE_SEA(Enchantment.LUCK,61,"luck_of_the_sea"),
	LURE(Enchantment.LURE,62,"lure"),
	MENDING(Enchantment.MENDING,70,"mending"),
	CURSE_OF_VANISHING(Enchantment.VANISHING_CURSE,71,"vanishing_curse");

	public final String name;
	public final int id;
	public final Enchantment enchantment;
	public final int vanillaMaxEnchantment;

	DPEnchantment(Enchantment enchantment, int id, String name) {
		this.enchantment = enchantment;
		this.id = id;
		this.name = name;
		this.vanillaMaxEnchantment = enchantment.getMaxLevel();
	}

}
