package de.dopebrot.dopeapi.region;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.UUID;

/**
 * A region defines a space between to coordinates.
 * @author DopeBrot
 * @see RegionManager
 * @since 7.0
 */

public class Region {

	private final Location start;
	private final Location end;
	private final UUID regionUUID;
	private String regionName;

	/**
	 * @param start starting location of the region
	 * @param end   ending location of the region
	 * @apiNote if the starting location is bigger than the ending it will be switched accordingly
	 * @author DopeBrot
	 * @since 7.0
	 */
	public Region(Location start, Location end) {
		this.regionUUID = UUID.randomUUID();
		regionName = regionUUID.toString();
		World world = start.getWorld();
		double sx = start.getX();
		double sy = start.getY();
		double sz = start.getZ();
		double ex = end.getX();
		double ey = end.getY();
		double ez = end.getZ();
		double tmp = 0;

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
	 *
	 * @author DopeBrot
	 * @since 7.0
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return starting location of region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public Location getStart() {
		return this.start;
	}

	/**
	 * @return ending location of region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public Location getEnd() {
		return this.end;
	}

	/**
	 * array size = 4 <br></br>
	 * {@index 0} = x*y*z size<br></br>
	 * {@index 1} = x size<br></br>
	 * {@index 2} = y size<br></br>
	 * {@index 3} = z size<br></br>
	 *
	 * @return size of the region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public double[] size() {
		double x = end.getX() - start.getX();
		double y = end.getY() - start.getY();
		double z = end.getZ() - start.getZ();
		double a = ((x * y) * z);
		return new double[]{a, x, y, z};
	}

	/**
	 * @return custom uuid of the region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public UUID getRegionUUID() {
		return regionUUID;
	}

	/**
	 * @return custom name of the region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @return a string in json format
	 * @author DopeBrot
	 * @since 7.0
	 */
	@Override
	public String toString() {
		return "Region{start=[" + start + "], end=[" + end + "], regionUUID=[" + regionUUID + "], regionName=['" + regionName + "\']}";
	}

}
