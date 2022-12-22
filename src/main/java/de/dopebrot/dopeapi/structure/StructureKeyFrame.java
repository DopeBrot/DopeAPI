package de.dopebrot.dopeapi.structure;
/**
 * The type Structure key frame.
 */
public class StructureKeyFrame {

	private Structure structure;
	private int wait;

	/**
	 * Instantiates a new Structure key frame.
	 *
	 * @param structure the structure
	 * @param wait      the wait
	 */
	public StructureKeyFrame(Structure structure, int wait) {
		this.structure = structure;
		this.wait = wait;
	}

	/**
	 * Gets structure.
	 *
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}
	/**
	 * Gets wait.
	 *
	 * @return the wait
	 */
	public int getWait() {
		return wait;
	}

}
