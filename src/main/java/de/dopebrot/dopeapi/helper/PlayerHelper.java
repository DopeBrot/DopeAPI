package de.dopebrot.dopeapi.helper;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerHelper {

	public static void playSound(Player player, Sound sound) {
		playSound(player, sound, 1f, 1f);
	}

	public static void playSound(Player player, Sound sound, float volume) {
		playSound(player, sound, volume, 1f);
	}

	public static void playSound(Player player, Sound sound, float volume, float pitch) {
		Validate.notNull(player);
		Validate.notNull(sound);
		player.playSound(player, sound, volume, pitch);
	}

	public static void teleport(Player player, Location location) {
		Validate.notNull(player);
		Validate.notNull(location);
		player.teleport(location);
	}

	public static void teleport(Player[] players, Location location) {
		Validate.noNullElements(players);
		for (Player p : players) {
			teleport(p, location);
		}
	}

}
