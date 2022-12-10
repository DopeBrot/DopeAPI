package de.dopebrot.dopeapi.region;
import de.dopebrot.dopeapi.annotation.ArrayLength;
import org.bukkit.Location;
import org.bukkit.Warning;
import org.bukkit.World;
import org.checkerframework.common.value.qual.ArrayLenRange;

import java.util.UUID;

public class Region {

	private final Location start;
	private final Location end;
	private final UUID regionUUID;
	private String regionName;

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

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Location getStart() {
		return this.start;
	}

	public Location getEnd() {
		return this.end;
	}

	@ArrayLength(length = 4)
	public double[] size() {
		double x = end.getX() - start.getX();
		double y = end.getY() - start.getY();
		double z = end.getZ() - start.getZ();
		double a = x * y * z;
		return new double[]{a, x, y, z};
	}

	public UUID getRegionUUID() {
		return regionUUID;
	}

	public String getRegionName() {
		return regionName;
	}

}
