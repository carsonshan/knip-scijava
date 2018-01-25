
package org.scijava.widget2;

import org.scijava.struct2.StructInstance;

public class AbstractWidgetPanel<C> implements WidgetPanel<C> {

	private StructInstance<C> struct;

	public AbstractWidgetPanel(StructInstance<C> struct) {
		this.struct = struct;
	}

	@Override
	public StructInstance<C> struct() { return struct; }

}