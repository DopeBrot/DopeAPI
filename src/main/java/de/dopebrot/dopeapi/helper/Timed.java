package de.dopebrot.dopeapi.helper;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * a timer class that counts down ticks.
 * if {@link #ticks} hit 0 {@link #alive()} will be false
 *
 * @author DopeBrot
 * @since 9.0
 */
public class Timed {

	private final UUID id;
	private int ticks;
	private int starting;
	private boolean alive;

	/**
	 * @param id    random UUID that should only exist once at a time.
	 * @param ticks how many ticks should this be alive
	 * @author DopeBrot
	 * @since 9.0
	 */
	public Timed(UUID id, int ticks) {
		this.id = id;
		this.ticks = ticks;
		this.starting = ticks;
		this.alive = true;
	}
	/**
	 * updates the ticks and checks if alive should be false
	 *
	 * @author DopeBrot
	 * @since 9.0
	 */
	public void update() {
		if (alive) {
			if (ticks >= 1) {
				ticks--;
			}
			if (ticks < 1) {
				alive = false;
			}
		}
	}

	/**
	 * @return true if not all ticks are counted down. false if all ticks are counted down.
	 * @author DopeBrot
	 * @since 9.0
	 */
	public boolean alive() {
		return alive;
	}

	/**
	 * @return {@link #id}
	 * @author DopeBrot
	 * @since 9.0
	 */
	@NotNull
	public UUID id() {
		return id;
	}

	/**
	 * @return current {@link #ticks} amount
	 * @author DopeBrot
	 * @since 9.0
	 */
	public int ticks() {
		return ticks;
	}

	/**
	 * @return at how much {@link #ticks} was started
	 * @author DopeBrot
	 * @since 9.0
	 */
	public int start() {
		return starting;
	}

	/**
	 * @return <b>true</b> if the <i>object</i> is equal to this, <b>false</b> if not
	 * @author DopeBrot
	 * @since 9.0
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Timed oth) {
			return oth.id == id;
		}
		return false;
	}

	/**
	 * @return a string representing this class
	 * <i>looks: "Timed{"id"=0,"ticks"=0,"alive"=false}"</i>
	 * @author DopeBrot
	 * @since 9.0
	 */
	@Override
	public String toString() {
		return "Timed{" + "id=" + id + ", ticks=" + ticks + ", alive=" + alive + "}";
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

}
