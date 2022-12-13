package de.dopebrot.dopeapi.structure;
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