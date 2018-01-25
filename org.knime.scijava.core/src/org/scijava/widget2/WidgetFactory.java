package org.scijava.widget2;

import org.scijava.plugin.SingletonPlugin;
import org.scijava.struct2.MemberInstance;

public interface WidgetFactory<W extends Widget> extends SingletonPlugin {

	boolean supports(MemberInstance<?> model);

	W create(MemberInstance<?> model,
		WidgetPanelFactory<? extends W> panelFactory);

	Class<W> widgetType();
}