package dev.volix.lib.regions;

import java.util.function.Function;

/**
 * Used to convert a generic vector to a specific simple vector
 * to be able to use the generic type {@code V} in classes without
 * losing the option to do vectorial calculations.
 *
 * @author Tobias Büser
 */
public interface VectorConverter<V> extends Function<V, Vector3d> {
}
