package de.dopebrot.dopeapi.region;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

public class Region {

	private final Location start;
	private final Location end;
	private final UUID regionUUID;
	private String regionName;

	/**
	 * @param start starting location of the region
	 * @param end   ending location of the region
	 * @apiNote if the starting location is bigger than the ending it will be switched accordingly
	 */
	public Region(Location start, Location end) {
		this.regionUUID = UUID.randomUUID();
		regionName = regionUUID.toString();
		World world = start.getWorld();
		double sx = start.getX();
		double sy = start.getY();
		double sz = start.getZ();
		double ex = end.getX();
		double ey = end.getX();
		double ez = end.getX();
		double tmp = 0;

		// switches from low to high
		if (sx > ex) {
			tmp = sx;
			sx = ex;
			ex = tmp;
		}
		if (sy > ey) {
			tmp = sy;
			sy = ey;
			ey = tmp;
		}
		if (sz > ez) {
			tmp = sz;
			sz = ez;
			ez = tmp;
		}
		this.start = new Location(world, sx, sy, sz);
		this.end = new Location(world, ex, ey, ez);
	}

	/**
	 * sets the name of the region
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return starting location of region
	 */
	public Location getStart() {
		return this.start;
	}

	/**
	 * @return ending location of region
	 */
	public Location getEnd() {
		return this.end;
	}

	/**
	 * array size = 4
	 *
	 * @return size of the region
	 */
	public double[] size() {
		double x = end.getX() - start.getX();
		double y = end.getY() - start.getY();
		double z = end.getZ() - start.getZ();
		double a = x * y * z;
		return new double[]{a, x, y, z};
	}

	/**
	 * @return custom uuid of the region
	 */
	public UUID getRegionUUID() {
		return regionUUID;
	}

	/**
	 * @return custom name of the region
	 */
	public String getRegionName() {
		return regionName;
	}

}
