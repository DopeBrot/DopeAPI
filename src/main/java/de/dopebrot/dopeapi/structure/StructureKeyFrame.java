package de.dopebrot.dopeapi.structure;
/**
 * The type Structure key frame.
 */
public class StructureKeyFrame {

	private Structure structure;
	private int delay;

	/**
	 * Instantiates a new Structure key frame.
	 *
	 * @param structure the structure
	 * @param wait      the delay
	 */
	public StructureKeyFrame(Structure structure, int wait) {
		this.structure = structure;
		this.delay = wait;
	}

	/**
	 * gets the {@link Structure}.
	 *
	 * @return the {@link Structure}
	 */
	public Structure structure() {
		return structure;
	}

	/**
	 * Gets delay.
	 *
	 * @return int as delay
	 */
	public int delay() {
		return delay;
	}

}
