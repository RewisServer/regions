package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public class SphereRegion<V> extends Region<V> {

    private final V center;
    private final double radius;

    private final double radiusSquared;
    private final Vector3d centerVector3d;

    public SphereRegion(final String key, final RegionPriority priority, final VectorConverter<V> converter,
                        final V center, final double radius) {
        super(key, priority, converter);

        if (center == null) throw new IllegalArgumentException("center cannot be null");
        if (radius <= 0) throw new IllegalArgumentException("radius cannot be 0 or negative");

        this.center = center;
        this.radius = radius;

        this.radiusSquared = radius * radius;
        this.centerVector3d = converter.apply(center);
    }

    @Override
    public boolean isInside(final double x, final double y, final double z) {
        final Vector3d distance = this.centerVector3d.subtract(x, y, z);
        return (distance.getX() * distance.getX()
            + distance.getY() * distance.getY()
            + distance.getZ() * distance.getZ()) <= this.radiusSquared;
    }

    public V getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

}
