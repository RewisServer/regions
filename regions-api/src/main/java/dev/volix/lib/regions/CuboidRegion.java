package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public class CuboidRegion<V> extends Region<V> {

    private final V pos1, pos2;

    private final Vector3d pos1Vector3d;
    private final Vector3d pos2Vector3d;

    public CuboidRegion(final String key, final RegionPriority priority, final VectorConverter<V> converter,
                        final V pos1, final V pos2) {
        super(key, priority, converter);

        if (pos1 == null) throw new IllegalArgumentException("pos1 cannot be null");
        if (pos2 == null) throw new IllegalArgumentException("pos2 cannot be null");

        this.pos1 = pos1;
        this.pos2 = pos2;

        this.pos1Vector3d = converter.apply(pos1);
        this.pos2Vector3d = converter.apply(pos2);
    }

    @Override
    public boolean isInside(final double x, final double y, final double z) {
        final double minX = Math.min(this.pos1Vector3d.getX(), this.pos2Vector3d.getX());
        final double minZ = Math.min(this.pos1Vector3d.getZ(), this.pos2Vector3d.getZ());
        final double minY = Math.min(this.pos1Vector3d.getY(), this.pos2Vector3d.getY());

        final double maxX = Math.max(this.pos1Vector3d.getX(), this.pos2Vector3d.getX());
        final double maxZ = Math.max(this.pos1Vector3d.getZ(), this.pos2Vector3d.getZ());
        final double maxY = Math.max(this.pos1Vector3d.getY(), this.pos2Vector3d.getY());

        return (minX <= x && x <= maxX) && (minZ <= z && z <= maxZ) && (minY <= y && y <= maxY);
    }

    public V getPos1() {
        return this.pos1;
    }

    public V getPos2() {
        return this.pos2;
    }

}
