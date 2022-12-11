package de.dopebrot.dopeapi.region;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.UUID;

public class RegionManager {

	private final ArrayList<Region> regions;

	public RegionManager() {
		this.regions = new ArrayList<>();
	}

	/**
	 * adds a region
	 * @param region the region that needs to be added
	 */
	public void addRegion(Region region) {
		this.regions.add(region);
	}

	/**
	 * removes a given region
	 *
	 * @param region the region that needs to be removed
	 */
	public void removeRegion(Region region) {
		this.regions.remove(region);
	}

	/**
	 * removes a region accordingly to their uuid
	 *
	 * @param uuid the uuid of the region that needs to be removed
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
	 * @param location location of the region that need to be found
	 * @return region where the location is inside
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
	 */
	public ArrayList<Region> getRegions() {
		return regions;
	}

}
