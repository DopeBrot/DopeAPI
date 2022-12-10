package de.dopebrot.dopeapi;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class DPOffset {

	private float x;
	private float y;
	private float z;

	public Vector toVector() {
		return new Vector(x, y, z);
	}

	public Location toLocation(World world) {
		Validate.notNull(world, "world can't be null!");
		return new Location(world, x, y, z);
	}

	public Vector addToVector(Vector vector) {
		Validate.notNull(vector,"vector can't be null!");
		return vector.add(toVector());
	}

	public DPOffset getInPercent(float percent) {
		DPOffset tmp = this;
		float f = percent/100;
		tmp.multiply(f,f,f);
		return tmp;
	}

	public void increase(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	public void decrease(float x, float y, float z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}

	public void multiply(float x, float y, float z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
	}

	public void divide(float x, float y, float z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
	}

	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public float getZ() {
		return z;
	}

}
