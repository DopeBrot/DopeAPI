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

	public void addRegion(Region region) {
		this.regions.add(region);
	}

	public void removeRegion(Region region) {
		this.regions.remove(region);
	}

	public void removeRegion(UUID uuid) {
		for (Region currentRegion : regions) {
			if (currentRegion.getRegionUUID() == uuid) {
				regions.remove(currentRegion);
				return;
			}
		}
	}

	public void removeRegion(String regionName) {
		for (Region currentRegion : regions) {
			if (currentRegion.getRegionName().equals(regionName)) {
				regions.remove(currentRegion);
				return;
			}
		}
	}

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

	public ArrayList<Region> getRegions() {
		return regions;
	}

}
