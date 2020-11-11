package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public class CylinderRegion<V> extends SphereRegion<V> {

    private final double height;

    private final double radiusXZSquared;
    private final Vector3d centerVector3d;

    public CylinderRegion(final String key, final RegionPriority priority, final VectorConverter<V> converter,
                          final V center, final double radiusXZ, final double height) {
        super(key, priority, converter, center, radiusXZ);

        if (height <= 0) throw new IllegalArgumentException("height cannot be 0 or negative");

        this.height = height;

        this.radiusXZSquared = radiusXZ * radiusXZ;
        this.centerVector3d = converter.apply(center);
    }

    @Override
    public boolean isInside(final double x, final double y, final double z) {
        final Vector3d distance = this.centerVector3d.subtract(x, 0.0, z);
        return (distance.getX() * distance.getX() + distance.getZ() * distance.getZ()) <= this.radiusXZSquared
            && this.centerVector3d.getY() <= y && y <= this.centerVector3d.getY() + this.height;
    }

    public double getHeight() {
        return this.height;
    }

}
