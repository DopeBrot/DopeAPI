package de.dopebrot.dopeapi.region;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This RegionManager can add/remove regions from a list.<br></br>
 * you can check if a location is inside a region and can return all regions.
 *
 * @author DopeBrot
 * @see Region
 * @since 7.0
 */

public class RegionManager {

	private final ArrayList<Region> regions;

	public RegionManager() {
		this.regions = new ArrayList<>();
	}

	/**
	 * adds a region
	 *
	 * @param region the region that needs to be added
	 * @author DopeBrot
	 * @since 7.0
	 */
	public void addRegion(Region region) {
		this.regions.add(region);
	}

	/**
	 * removes a given region
	 *
	 * @param region the region that needs to be removed
	 * @author DopeBrot
	 * @since 7.0
	 */
	public void removeRegion(Region region) {
		this.regions.remove(region);
	}

	/**
	 * removes a region accordingly to their uuid
	 *
	 * @param uuid the uuid of the region that needs to be removed
	 * @author DopeBrot
	 * @since 7.0
	 */
	public void removeRegion(UUID uuid) {
		for (Region currentRegion : regions) {
			if (currentRegion.getRegionUUID() == uuid) {
				regions.remove(currentRegion);
				return;
			}
		}
	}

	/**
	 * removes a region accordingly to their name
	 *
	 * @param regionName the name of the region that needs to be removed
	 * @author DopeBrot
	 * @since 7.0
	 */
	public void removeRegion(String regionName) {
		for (Region currentRegion : regions) {
			if (currentRegion.getRegionName().equals(regionName)) {
				regions.remove(currentRegion);
				return;
			}
		}
	}

	/**
	 * @param location location that needs to be checked
	 * @return true if location is inside any region
	 * @author DopeBrot
	 * @since 7.0
	 */
	public boolean isInside(Location location) {
		for (Region currentRegion : regions) {
			if (currentRegion.getStart().getX() > location.getX()
					&& currentRegion.getStart().getY() > location.getY()
					&& currentRegion.getStart().getZ() > location.getZ()) {
				if (currentRegion.getEnd().getX() < location.getX()
						&& currentRegion.getEnd().getY() < location.getY()
						&& currentRegion.getEnd().getZ() < location.getZ()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param location location that needs to be searched for
	 * @return {@link Region} array that are inside the location
	 * @author DopeBrot
	 * @since 7.0
	 */
	public Region[] getInside(Location location) {
		ArrayList<Region> regionList = new ArrayList<>();
		for (Region currentRegion : regions) {
			if (currentRegion.getStart().getX() > location.getX()
					&& currentRegion.getStart().getY() > location.getY()
					&& currentRegion.getStart().getZ() > location.getZ()) {
				if (currentRegion.getEnd().getX() < location.getX()
						&& currentRegion.getEnd().getY() < location.getY()
						&& currentRegion.getEnd().getZ() < location.getZ()) {
					regionList.add(currentRegion);
				}
			}
		}
		return regionList.toArray(new Region[0]);
	}

	/**
	 * @param location location of the region that need to be found
	 * @return region where the location is inside
	 * @author DopeBrot
	 * @since 7.0
	 */
	@Nullable
	public Region getRegion(Location location) {
		for (Region currentRegion : regions) {
			if (currentRegion.getStart().getX() > location.getX()
					&& currentRegion.getStart().getY() > location.getY()
					&& currentRegion.getStart().getZ() > location.getZ()) {
				if (currentRegion.getEnd().getX() < location.getX()
						&& currentRegion.getEnd().getY() < location.getY()
						&& currentRegion.getEnd().getZ() < location.getZ()) {
					return currentRegion;
				}
			}
		}
		return null;
	}

	/**
	 * return ArrayList of all region there are
	 *
	 * @author DopeBrot
	 * @since 7.0
	 */
	public ArrayList<Region> getRegions() {
		return regions;
	}

}
