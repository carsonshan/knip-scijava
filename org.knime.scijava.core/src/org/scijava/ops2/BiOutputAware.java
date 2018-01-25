package org.scijava.ops2;

@FunctionalInterface
public interface BiOutputAware<I1, I2, O> {
	O createOutput(I1 in1, I2 in2);
}