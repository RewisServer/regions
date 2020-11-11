package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public abstract class Region<V> {

    private final String key;
    private final int priority;

    private final VectorConverter<V> converter;

    public Region(final String key, final RegionPriority priority, final VectorConverter<V> converter) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (converter == null) throw new IllegalArgumentException("converter cannot be null");

        this.key = key;
        this.priority = priority.getVal();
        this.converter = converter;
    }

    public abstract boolean isInside(final double x, final double y, final double z);

    public boolean isInside(final V vector) {
        Vector3d v = this.converter.apply(vector);
        return this.isInside(v.getX(), v.getY(), v.getZ());
    }

    public String getKey() {
        return this.key;
    }

    public int getPriority() {
        return this.priority;
    }

}
