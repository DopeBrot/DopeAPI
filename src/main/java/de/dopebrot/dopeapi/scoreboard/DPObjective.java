package de.dopebrot.dopeapi.scoreboard;
import net.kyori.adventure.text.Component;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;

/**
 * @version alpha 0.1
 */
public class DPObjective {

	private final ArrayList<Score> scores;
	private final Objective objective;
	private final Scoreboard scoreboard;
	private int scroll = 0;
	private final int id;

	public DPObjective(Scoreboard scoreboard, int id, String name, String displayName) {
		this.id = id;
		this.scoreboard = scoreboard;
		this.objective = scoreboard.registerNewObjective(name, "dummy", Component.text(displayName));
		this.scores = new ArrayList<>();
	}

	public void setField(int position, String displayType) {
		scores.add(position, this.objective.getScore(displayType));
	}

	public void scroll(int position) {
		this.scroll = position;
	}

	public void update() {
		for (int i = scroll; i < 15; i++) {
			Score cur = this.scores.get(i);
			if (cur != null) {
				cur.setScore(i);
				Score tmp = cur.getObjective().getScore(cur.getEntry());
				tmp.setScore(i);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DPObjective cur) {
			return cur.id == this.id;
		}
		return false;
	}

	public int id() {
		return id;
	}

	public Objective objective() {
		return objective;
	}

	public Scoreboard scoreboard() {
		return scoreboard;
	}

	public ArrayList<Score> scores() {
		return scores;
	}

	public void render(DisplaySlot displaySlot) {
		this.objective.setDisplaySlot(displaySlot);
	}

}
