
package org.scijava.swing.widget2;

import javax.swing.JComponent;

import org.scijava.widget2.Widget;
import org.scijava.widget2.Widgets;

/** Utility class for working with {@link Widget}s and Swing. */
public final class SwingWidgets {

	private SwingWidgets() {
		// NB: Prevent instantiation of utility class.
	}

	/** Assigns the widget's description as the given component's tool tip. */
	public static void setToolTip(final Widget widget, final JComponent c) {
		final String desc = Widgets.description(widget);
		if (desc == null || desc.isEmpty()) return;
		c.setToolTipText(desc);
	}
}