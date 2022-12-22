package de.dopebrot.dopeapi.structure;
/**
 * The type Structure block.
 */
public record StructureBlock(
		int x,
		int y,
		int z,
		String blockData) {

		@Override
		public String toString() {
			return "{x:" + x + ",y:" + y + ",z:" + z + ",blockData:" + blockData + "}";
		}

}