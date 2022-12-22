package de.dopebrot.dopeapi.helper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 * <h1> {@link #TimedUUID} can be used as a spam filter for actions from {@link UUID}.</h1>
 * the class saves {@link UUID} in {@link #timedList} with ticks.
 * they will get updated every {@link #refreshRate}.
 * if there ticks will get to 0 they will be removed from {@link #timedList}.<br></br>
 * to check if a player can perform an action,
 * just ask if the uuid of a player is inside of {@link #timedList} using {@link #contains(UUID)}
 *
 * @author DopeBrot
 * @since 9.0
 */
public class TimedUUID {

	private final ArrayList<Timed> timedList;
	private final int refreshRate;
	private final Timer timer;
	private int taskID;
	private TimerTask timerTask;

	/**
	 * Instantiates a new TimedUUID.
	 *
	 * @param refreshRate how many ticks the scheduler ask for {@link Timed} objects. influences performance
	 *                    higher values are for better performance but inaccurate.
	 *                    lower values are calling {@link Timed} objects more frequently.
	 * @default <b>refreshRate </b> 1000
	 * @author DopeBrot
	 * @since 9.0
	 */
	public TimedUUID(int refreshRate) {
		this.timer = new Timer();
		this.refreshRate = refreshRate;
		this.timedList = new ArrayList<>();
		init();
	}

	/**
	 * Instantiates a new TimedUUID.
	 *
	 * @author DopeBrot
	 * @since 9.0
	 */
	public TimedUUID() {
		this.refreshRate = 1000; // 1 sec
		this.timer = new Timer();
		this.timedList = new ArrayList<>();
		init();
	}

	private void init() {
		timerTask = new TimerTask() {
			@Override
			public void run() {
				update();
			}
		};
		timer.scheduleAtFixedRate(timerTask, 0, refreshRate);
	}

	/**
	 * adds a new {@link Timed} to {@link #timedList} in seconds,
	 * seconds will be calculated from {@link #refreshRate}
	 *
	 * @param playerUUID the {@link org.bukkit.entity.Player} {@link UUID}
	 * @param seconds    how many seconds should {@link Timed} be alive
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void add(UUID playerUUID, Integer seconds) {
		int a = (int) (seconds * (1000f / this.refreshRate));
		this.timedList.add(new Timed(playerUUID, a));
	}

	/**
	 * adds a new {@link Timed} to {@link #timedList} in ticks
	 *
	 * @param playerUUID the {@link UUID} of a {@link org.bukkit.entity.Player}
	 * @param ticks      the amount of ticks
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void addTicks(UUID playerUUID, Integer ticks) {
		this.timedList.add(new Timed(playerUUID, ticks));
	}

	/**
	 * starts {@link #timerTask}.
	 *
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void start() {
		timerTask.run();
	}

	/**
	 * this updates {@link #timedList}
	 * and removes all dead
	 *
	 * @apiNote this will get called from {@link #timerTask}
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void update() {
		timedList.removeIf(timed -> !timed.alive());
		for (Timed timed : timedList) {
			timed.update();
		}
	}

	/**
	 * stops {@link #timerTask}.
	 *
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void stop() {
		if (timerTask != null) {
			timerTask.cancel();
		}
	}

	/**
	 * is {@link #timedList empty}.
	 *
	 * @return <b>true</b>  if the list is empty, <b>false</b>  if not
	 * @author DopeBrot
	 * @since 9.0
	 */
	public boolean isEmpty() {
		return this.timedList.isEmpty();
	}

	/**
	 * does the {@link UUID} exist in {@link #timedList}
	 *
	 * @param playerUUID uuid of a player
	 * @return <b>true</b> if player is in the list, <b>false</b>  if not
	 * @author DopeBrot
	 * @since 9.0
	 */
	public boolean contains(UUID playerUUID) {
		if (!timedList.isEmpty()) {
			for (Timed t : timedList) {
				if (t.id().equals(playerUUID)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * gets the remaining ticks from an uuid
	 *
	 * @param playerUUID {@link UUID} the uuid that should be searched for
	 * @return the ticks of that players {@link Timed} object <b>or -99 if the {@link UUID} wasn't found!</b>
	 * @author DopeBrot
	 * @since 9.0
	 */
	public int getTicks(UUID playerUUID) {
		if (!timedList.isEmpty()) {
			for (Timed timed : timedList) {
				if (timed.id().equals(playerUUID)) {
					return timed.ticks();
				}
			}
		}
		return -99;
	}

	/**
	 * calculates ticks to seconds
	 *
	 * @param ticksMS the current ticks.
	 * @return ticks in seconds using {@link #refreshRate}.
	 * @author DopeBrot
	 * @since 9.0
	 */
	public float getInSeconds(int ticksMS) {
		return Math.round(((this.refreshRate * ticksMS) / 1000f) * 10f) / 10f;
	}

	/**
	 * all {@link Timed} objects there are currently
	 *
	 * @return {@link #timedList}
	 * @author DopeBrot
	 * @since 9.0
	 */
	@NotNull
	public ArrayList<Timed> timedList() {
		return timedList;
	}

	/**
	 * How often does the scheduler {@link #timerTask} call.
	 * 1000ms = 1 second.
	 *
	 * @return int as refresh Rate.
	 * @author DopeBrot
	 * @since 9.0
	 */
	public int refreshRate() {
		return refreshRate;
	}

	/**
	 * @param object object that need to be checked.
	 * @return <b>true</b> if object is the same as <i>object</i>, <b>false</b> if not
	 * @author DopeBrot
	 * @since 9.0
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof TimedUUID timedUUID) {
			return timedUUID.taskID == taskID;
		}
		return false;
	}

	/**
	 * @return hashCode
	 * @author DopeBrot
	 * @since 9.0
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * @return all {@link Timed} as a string
	 * @author DopeBrot
	 * @since 9.0
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("TimedUUID{");
		builder.append("timed=[");
		for (int i = 0; i < timedList.size(); i++) {
			builder.append(timedList.get(i));
			if (timedList.size() > 1) {
				if (i < timedList.size() - 1) {
					builder.append(",");
				}
			}
		}
		builder.append("]");
		builder.append(",refreshRate=").append(refreshRate);
		builder.append(",taskID=").append(taskID);
		builder.append("}");
		return builder.toString();
	}

}
