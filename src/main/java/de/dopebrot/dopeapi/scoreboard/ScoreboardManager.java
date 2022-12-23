package de.dopebrot.dopeapi.scoreboard;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @version alpha 0.3
 */

public class ScoreboardManager {

	private final Scoreboard scoreboard;
	private final Plugin plugin;
	private final HashMap<Integer, DPObjective> objectives;
	private final ArrayList<Player> registeredPlayers;
	private DPObjective currentObjective;

	public ScoreboardManager(Plugin plugin) {
		this.plugin = plugin;
		this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		this.objectives = new HashMap<>();
		this.registeredPlayers = new ArrayList<>();
	}

	public void registerPlayer(Player player) {
		Validate.notNull(player);
		if (player.isOnline()) {
			if (!registeredPlayers.contains(player)) {
				this.registeredPlayers.add(player);
			}
		}
	}

	public void registerPlayers(Player[] players) {
		Validate.notNull(players);
		Validate.noNullElements(players);
		for (Player p : players) {
			if (p.isOnline()) {
				if (!registeredPlayers.contains(p)) {
					this.registeredPlayers.add(p);
				}
			}
		}
	}

	public void removePlayers(Player[] players) {
		Validate.notNull(players);
		Validate.noNullElements(players);
		for (Player p : players) {
			if (p.isOnline()) {
				this.registeredPlayers.remove(p);
			}
		}

	}

	public void removePlayer(Player player) {
		Validate.notNull(player);
		if (player.isOnline()) {
			this.registeredPlayers.remove(player);
		}
	}

	public void update() {
		for (Player player : registeredPlayers) {
			if (player == null || !player.isOnline()) {
				removePlayer(player);
				continue;
			}
			player.setScoreboard(scoreboard);
		}
	}

	public DPObjective registerObjective(int id, String name, String displayName) {
		DPObjective objective = new DPObjective(scoreboard, id, name, displayName);
		this.objectives.put(id, objective);
		return objective;
	}

	public void addObjective(DPObjective dpObjective) {
		this.objectives.put(dpObjective.id(), dpObjective);
	}

	public void currentObjective(int id) {
		if (objectives.size() >= id) {
			this.currentObjective = objectives.get(id);
		}
	}

}
