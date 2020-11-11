package dev.volix.lib.regions;

import dev.volix.lib.grape.Service;
import java.util.List;

/**
 * @author Tobias Büser
 */
public interface RegionService<V> extends Service {

    /**
     * Gets a region, which has been registered with given key.
     * If no region found, return null.
     *
     * @param key Key of the region, must be unique.
     * @param <T> Type of region. (e.g. {@link CuboidRegion})
     *
     * @return The region or null.
     */
    <T extends Region<V>> T get(String key);

    /**
     * Returns every region which contains given vector inside.
     *
     * @return List of regions, may be empty.
     */
    List<Region<V>> getAll(V vector);

    /**
     * Returns the highest priority region at given vector.
     * <p>
     * First uses {@link #getAll(Object)} to get all regions at this position.
     * Then it filters this list with their priority to get the region with the
     * highest one. If two regions have the same highest priority, the result
     * is undefined.
     * <p>
     * So in the implementation it is better to just ignore same priorities with
     * changing regions, as it could lead to unexpected behaviour.
     *
     * @param vector The position to get the region from.
     *
     * @return The highest priority region at {@code vector}.
     */
    Region<V> getFirst(V vector);

    /**
     * Registers a region to the service.
     * This way the service can handle the region's functionality
     * automatically.
     *
     * @param region The region. Uses {@link Region#getKey()} for mapping.
     * @param <T>    Type of region.
     */
    <T extends Region<V>> void register(T region);

    /**
     * Unregisters the region with given {@code key}.
     *
     * @param key {@link Region#getKey()}, cannot be null.
     */
    void unregister(String key);

}
