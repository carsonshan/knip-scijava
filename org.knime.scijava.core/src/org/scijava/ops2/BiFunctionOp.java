
package org.scijava.ops2;

/** Binary function, as a plugin. */
@FunctionalInterface
public interface BiFunctionOp<I1, I2, O> extends
	java.util.function.BiFunction<I1, I2, O>
{}