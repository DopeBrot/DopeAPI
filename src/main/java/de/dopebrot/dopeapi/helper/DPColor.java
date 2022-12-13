package de.dopebrot.dopeapi.helper;

import org.bukkit.Material;

public enum DPColor {

	BLOCK_WHITE(0), BLOCK_ORANGE(1), BLOCK_MAGENTA(2), BLOCK_LIGHT_BLUE(3), BLOCK_YELLOW(4), BLOCK_LIME(5), BLOCK_PINK(6), BLOCK_GRAY(7), BLOCK_LIGHT_GRAY(8), BLOCK_CYAN(9), BLOCK_PURPLE(10), BLOCK_BLUE(11), BLOCK_BROWN(12), BLOCK_GREEN(13), BLOCK_RED(14), BLOCK_BLACK(15),

	CHAT_DARK_RED("§4"), CHAT_RED("§c"), CHAT_GOLD("§6"), CHAT_YELLOW("§e"), CHAT_DARK_GREEN("§2"), CHAT_GREEN("§a"), CHAT_AQUA("§b"), CHAT_DARK_AQUA("§3"), CHAT_DARK_BLUE("§1"), CHAT_BLUE("§9"), CHAT_LIGHT_PURPLE("§d"), CHAT_DARK_PURPLE("§5"), CHAT_WHITE("§f"), CHAT_GRAY("§7"), CHAT_DARK_GRAY("§8"), CHAT_BLACK("§0"), CHAT_OBFUSCATED("§k"), CHAT_BOLD("§l"), CHAT_STRIKETROUGH("§m"), CHAT_UNDERLINE("§n"), CHAT_ITALIC("§o"), CHAT_RESET("§r");
	private String prefix;
	private int id;

	DPColor(String prefix) {
		this.prefix = prefix;
	}

	DPColor(int id) {
		this.id = id;
	}

	/**
	 * @return color id
	 * @author DopeBrot
	 * @since 1.0
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return color name
	 * @author DopeBrot
	 * @since 1.0
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getConcretePowder(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_CONCRETE_POWDER;
			case 1 ->
					Material.ORANGE_CONCRETE_POWDER;
			case 2 ->
					Material.MAGENTA_CONCRETE_POWDER;
			case 3 ->
					Material.LIGHT_BLUE_CONCRETE_POWDER;
			case 4 ->
					Material.YELLOW_CONCRETE_POWDER;
			case 5 ->
					Material.LIME_CONCRETE_POWDER;
			case 6 ->
					Material.PINK_CONCRETE_POWDER;
			case 7 ->
					Material.GRAY_CONCRETE_POWDER;
			case 8 ->
					Material.LIGHT_GRAY_CONCRETE_POWDER;
			case 9 ->
					Material.CYAN_CONCRETE_POWDER;
			case 10 ->
					Material.PURPLE_CONCRETE_POWDER;
			case 11 ->
					Material.BLUE_CONCRETE_POWDER;
			case 12 ->
					Material.BROWN_CONCRETE_POWDER;
			case 13 ->
					Material.GREEN_CONCRETE_POWDER;
			case 14 ->
					Material.RED_CONCRETE_POWDER;
			case 15 ->
					Material.BLACK_CONCRETE_POWDER;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getConcrete(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_CONCRETE;
			case 1 ->
					Material.ORANGE_CONCRETE;
			case 2 ->
					Material.MAGENTA_CONCRETE;
			case 3 ->
					Material.LIGHT_BLUE_CONCRETE;
			case 4 ->
					Material.YELLOW_CONCRETE;
			case 5 ->
					Material.LIME_CONCRETE;
			case 6 ->
					Material.PINK_CONCRETE;
			case 7 ->
					Material.GRAY_CONCRETE;
			case 8 ->
					Material.LIGHT_GRAY_CONCRETE;
			case 9 ->
					Material.CYAN_CONCRETE;
			case 10 ->
					Material.PURPLE_CONCRETE;
			case 11 ->
					Material.BLUE_CONCRETE;
			case 12 ->
					Material.BROWN_CONCRETE;
			case 13 ->
					Material.GREEN_CONCRETE;
			case 14 ->
					Material.RED_CONCRETE;
			case 15 ->
					Material.BLACK_CONCRETE;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getBanner(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_BANNER;
			case 1 ->
					Material.ORANGE_BANNER;
			case 2 ->
					Material.MAGENTA_BANNER;
			case 3 ->
					Material.LIGHT_BLUE_BANNER;
			case 4 ->
					Material.YELLOW_BANNER;
			case 5 ->
					Material.LIME_BANNER;
			case 6 ->
					Material.PINK_BANNER;
			case 7 ->
					Material.GRAY_BANNER;
			case 8 ->
					Material.LIGHT_GRAY_BANNER;
			case 9 ->
					Material.CYAN_BANNER;
			case 10 ->
					Material.PURPLE_BANNER;
			case 11 ->
					Material.BLUE_BANNER;
			case 12 ->
					Material.BROWN_BANNER;
			case 13 ->
					Material.GREEN_BANNER;
			case 14 ->
					Material.RED_BANNER;
			case 15 ->
					Material.BLACK_BANNER;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getBed(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_BED;
			case 1 ->
					Material.ORANGE_BED;
			case 2 ->
					Material.MAGENTA_BED;
			case 3 ->
					Material.LIGHT_BLUE_BED;
			case 4 ->
					Material.YELLOW_BED;
			case 5 ->
					Material.LIME_BED;
			case 6 ->
					Material.PINK_BED;
			case 7 ->
					Material.GRAY_BED;
			case 8 ->
					Material.LIGHT_GRAY_BED;
			case 9 ->
					Material.CYAN_BED;
			case 10 ->
					Material.PURPLE_BED;
			case 11 ->
					Material.BLUE_BED;
			case 12 ->
					Material.BROWN_BED;
			case 13 ->
					Material.GREEN_BED;
			case 14 ->
					Material.RED_BED;
			case 15 ->
					Material.BLACK_BED;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getCandle(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_CANDLE;
			case 1 ->
					Material.ORANGE_CANDLE;
			case 2 ->
					Material.MAGENTA_CANDLE;
			case 3 ->
					Material.LIGHT_BLUE_CANDLE;
			case 4 ->
					Material.YELLOW_CANDLE;
			case 5 ->
					Material.LIME_CANDLE;
			case 6 ->
					Material.PINK_CANDLE;
			case 7 ->
					Material.GRAY_CANDLE;
			case 8 ->
					Material.LIGHT_GRAY_CANDLE;
			case 9 ->
					Material.CYAN_CANDLE;
			case 10 ->
					Material.PURPLE_CANDLE;
			case 11 ->
					Material.BLUE_CANDLE;
			case 12 ->
					Material.BROWN_CANDLE;
			case 13 ->
					Material.GREEN_CANDLE;
			case 14 ->
					Material.RED_CANDLE;
			case 15 ->
					Material.BLACK_CANDLE;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getCarpet(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_CARPET;
			case 1 ->
					Material.ORANGE_CARPET;
			case 2 ->
					Material.MAGENTA_CARPET;
			case 3 ->
					Material.LIGHT_BLUE_CARPET;
			case 4 ->
					Material.YELLOW_CARPET;
			case 5 ->
					Material.LIME_CARPET;
			case 6 ->
					Material.PINK_CARPET;
			case 7 ->
					Material.GRAY_CARPET;
			case 8 ->
					Material.LIGHT_GRAY_CARPET;
			case 9 ->
					Material.CYAN_CARPET;
			case 10 ->
					Material.PURPLE_CARPET;
			case 11 ->
					Material.BLUE_CARPET;
			case 12 ->
					Material.BROWN_CARPET;
			case 13 ->
					Material.GREEN_CARPET;
			case 14 ->
					Material.RED_CARPET;
			case 15 ->
					Material.BLACK_CARPET;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getDye(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_DYE;
			case 1 ->
					Material.ORANGE_DYE;
			case 2 ->
					Material.MAGENTA_DYE;
			case 3 ->
					Material.LIGHT_BLUE_DYE;
			case 4 ->
					Material.YELLOW_DYE;
			case 5 ->
					Material.LIME_DYE;
			case 6 ->
					Material.PINK_DYE;
			case 7 ->
					Material.GRAY_DYE;
			case 8 ->
					Material.LIGHT_GRAY_DYE;
			case 9 ->
					Material.CYAN_DYE;
			case 10 ->
					Material.PURPLE_DYE;
			case 11 ->
					Material.BLUE_DYE;
			case 12 ->
					Material.BROWN_DYE;
			case 13 ->
					Material.GREEN_DYE;
			case 14 ->
					Material.RED_DYE;
			case 15 ->
					Material.BLACK_DYE;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getGlazedTerracotta(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_GLAZED_TERRACOTTA;
			case 1 ->
					Material.ORANGE_GLAZED_TERRACOTTA;
			case 2 ->
					Material.MAGENTA_GLAZED_TERRACOTTA;
			case 3 ->
					Material.LIGHT_BLUE_GLAZED_TERRACOTTA;
			case 4 ->
					Material.YELLOW_GLAZED_TERRACOTTA;
			case 5 ->
					Material.LIME_GLAZED_TERRACOTTA;
			case 6 ->
					Material.PINK_GLAZED_TERRACOTTA;
			case 7 ->
					Material.GRAY_GLAZED_TERRACOTTA;
			case 8 ->
					Material.LIGHT_GRAY_GLAZED_TERRACOTTA;
			case 9 ->
					Material.CYAN_GLAZED_TERRACOTTA;
			case 10 ->
					Material.PURPLE_GLAZED_TERRACOTTA;
			case 11 ->
					Material.BLUE_GLAZED_TERRACOTTA;
			case 12 ->
					Material.BROWN_GLAZED_TERRACOTTA;
			case 13 ->
					Material.GREEN_GLAZED_TERRACOTTA;
			case 14 ->
					Material.RED_GLAZED_TERRACOTTA;
			case 15 ->
					Material.BLACK_GLAZED_TERRACOTTA;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getShulkerBox(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_SHULKER_BOX;
			case 1 ->
					Material.ORANGE_SHULKER_BOX;
			case 2 ->
					Material.MAGENTA_SHULKER_BOX;
			case 3 ->
					Material.LIGHT_BLUE_SHULKER_BOX;
			case 4 ->
					Material.YELLOW_SHULKER_BOX;
			case 5 ->
					Material.LIME_SHULKER_BOX;
			case 6 ->
					Material.PINK_SHULKER_BOX;
			case 7 ->
					Material.GRAY_SHULKER_BOX;
			case 8 ->
					Material.LIGHT_GRAY_SHULKER_BOX;
			case 9 ->
					Material.CYAN_SHULKER_BOX;
			case 10 ->
					Material.PURPLE_SHULKER_BOX;
			case 11 ->
					Material.BLUE_SHULKER_BOX;
			case 12 ->
					Material.BROWN_SHULKER_BOX;
			case 13 ->
					Material.GREEN_SHULKER_BOX;
			case 14 ->
					Material.RED_SHULKER_BOX;
			case 15 ->
					Material.BLACK_SHULKER_BOX;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getStainedGlass(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_STAINED_GLASS;
			case 1 ->
					Material.ORANGE_STAINED_GLASS;
			case 2 ->
					Material.MAGENTA_STAINED_GLASS;
			case 3 ->
					Material.LIGHT_BLUE_STAINED_GLASS;
			case 4 ->
					Material.YELLOW_STAINED_GLASS;
			case 5 ->
					Material.LIME_STAINED_GLASS;
			case 6 ->
					Material.PINK_STAINED_GLASS;
			case 7 ->
					Material.GRAY_STAINED_GLASS;
			case 8 ->
					Material.LIGHT_GRAY_STAINED_GLASS;
			case 9 ->
					Material.CYAN_STAINED_GLASS;
			case 10 ->
					Material.PURPLE_STAINED_GLASS;
			case 11 ->
					Material.BLUE_STAINED_GLASS;
			case 12 ->
					Material.BROWN_STAINED_GLASS;
			case 13 ->
					Material.GREEN_STAINED_GLASS;
			case 14 ->
					Material.RED_STAINED_GLASS;
			case 15 ->
					Material.BLACK_STAINED_GLASS;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getStainedGlassPane(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_STAINED_GLASS_PANE;
			case 1 ->
					Material.ORANGE_STAINED_GLASS_PANE;
			case 2 ->
					Material.MAGENTA_STAINED_GLASS_PANE;
			case 3 ->
					Material.LIGHT_BLUE_STAINED_GLASS_PANE;
			case 4 ->
					Material.YELLOW_STAINED_GLASS_PANE;
			case 5 ->
					Material.LIME_STAINED_GLASS_PANE;
			case 6 ->
					Material.PINK_STAINED_GLASS_PANE;
			case 7 ->
					Material.GRAY_STAINED_GLASS_PANE;
			case 8 ->
					Material.LIGHT_GRAY_STAINED_GLASS_PANE;
			case 9 ->
					Material.CYAN_STAINED_GLASS_PANE;
			case 10 ->
					Material.PURPLE_STAINED_GLASS_PANE;
			case 11 ->
					Material.BLUE_STAINED_GLASS_PANE;
			case 12 ->
					Material.BROWN_STAINED_GLASS_PANE;
			case 13 ->
					Material.GREEN_STAINED_GLASS_PANE;
			case 14 ->
					Material.RED_STAINED_GLASS_PANE;
			case 15 ->
					Material.BLACK_STAINED_GLASS_PANE;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getTerracotta(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_TERRACOTTA;
			case 1 ->
					Material.ORANGE_TERRACOTTA;
			case 2 ->
					Material.MAGENTA_TERRACOTTA;
			case 3 ->
					Material.LIGHT_BLUE_TERRACOTTA;
			case 4 ->
					Material.YELLOW_TERRACOTTA;
			case 5 ->
					Material.LIME_TERRACOTTA;
			case 6 ->
					Material.PINK_TERRACOTTA;
			case 7 ->
					Material.GRAY_TERRACOTTA;
			case 8 ->
					Material.LIGHT_GRAY_TERRACOTTA;
			case 9 ->
					Material.CYAN_TERRACOTTA;
			case 10 ->
					Material.PURPLE_TERRACOTTA;
			case 11 ->
					Material.BLUE_TERRACOTTA;
			case 12 ->
					Material.BROWN_TERRACOTTA;
			case 13 ->
					Material.GREEN_TERRACOTTA;
			case 14 ->
					Material.RED_TERRACOTTA;
			case 15 ->
					Material.BLACK_TERRACOTTA;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getWallBanner(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_WALL_BANNER;
			case 1 ->
					Material.ORANGE_WALL_BANNER;
			case 2 ->
					Material.MAGENTA_WALL_BANNER;
			case 3 ->
					Material.LIGHT_BLUE_WALL_BANNER;
			case 4 ->
					Material.YELLOW_WALL_BANNER;
			case 5 ->
					Material.LIME_WALL_BANNER;
			case 6 ->
					Material.PINK_WALL_BANNER;
			case 7 ->
					Material.GRAY_WALL_BANNER;
			case 8 ->
					Material.LIGHT_GRAY_WALL_BANNER;
			case 9 ->
					Material.CYAN_WALL_BANNER;
			case 10 ->
					Material.PURPLE_WALL_BANNER;
			case 11 ->
					Material.BLUE_WALL_BANNER;
			case 12 ->
					Material.BROWN_WALL_BANNER;
			case 13 ->
					Material.GREEN_WALL_BANNER;
			case 14 ->
					Material.RED_WALL_BANNER;
			case 15 ->
					Material.BLACK_WALL_BANNER;
			default ->
					null;
		};
	}
	/**
	 * @param i Integer from 0 to 15
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getWool(int i) {
		return switch (i) {
			case 0 ->
					Material.WHITE_WOOL;
			case 1 ->
					Material.ORANGE_WOOL;
			case 2 ->
					Material.MAGENTA_WOOL;
			case 3 ->
					Material.LIGHT_BLUE_WOOL;
			case 4 ->
					Material.YELLOW_WOOL;
			case 5 ->
					Material.LIME_WOOL;
			case 6 ->
					Material.PINK_WOOL;
			case 7 ->
					Material.GRAY_WOOL;
			case 8 ->
					Material.LIGHT_GRAY_WOOL;
			case 9 ->
					Material.CYAN_WOOL;
			case 10 ->
					Material.PURPLE_WOOL;
			case 11 ->
					Material.BLUE_WOOL;
			case 12 ->
					Material.BROWN_WOOL;
			case 13 ->
					Material.GREEN_WOOL;
			case 14 ->
					Material.RED_WOOL;
			case 15 ->
					Material.BLACK_WOOL;
			default ->
					null;
		};
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getConcretePowder(DPColor color) {
		return getConcretePowder(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getConcrete(DPColor color) {
		return getConcrete(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getBanner(DPColor color) {
		return getBanner(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getBed(DPColor color) {
		return getBed(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getCandle(DPColor color) {
		return getCandle(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getCarpet(DPColor color) {
		return getCarpet(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getDye(DPColor color) {
		return getDye(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getGlazedTerracotta(DPColor color) {
		return getGlazedTerracotta(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getShulkerBox(DPColor color) {
		return getShulkerBox(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getStainedGlass(DPColor color) {
		return getStainedGlass(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getStainedGlassPane(DPColor color) {
		return getStainedGlassPane(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getTerracotta(DPColor color) {
		return getTerracotta(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getWallBanner(DPColor color) {
		return getWallBanner(color.getId());
	}
	/**
	 * @param color {@link DPColor}
	 * @return Material
	 * @author DopeBrot
	 * @since 1.0
	 */
	public static Material getWool(DPColor color) {
		return getWool(color.getId());
	}

}
