package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public class Vector3d {

    private final double x, y, z;

    public Vector3d(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d() {
        this(0D, 0D, 0D);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public Vector3d subtract(final Vector3d other) {
        return new Vector3d(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3d subtract(final double x, final double y, final double z) {
        return new Vector3d(this.x - x, this.y - y, this.z - z);
    }

    public Vector3d add(final Vector3d other) {
        return new Vector3d(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3d add(final double x, final double y, final double z) {
        return new Vector3d(this.x + x, this.y + y, this.z + z);
    }

}
