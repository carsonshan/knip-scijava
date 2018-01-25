
package org.scijava.swing.widget2;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.scijava.plugin.Plugin;
import org.scijava.struct2.StructInstance;
import org.scijava.widget.UIComponent;
import org.scijava.widget2.AbstractWidgetPanel;
import org.scijava.widget2.WidgetPanel;
import org.scijava.widget2.WidgetPanelFactory;
import org.scijava.widget2.Widgets;

@Plugin(type = WidgetPanelFactory.class)
public class SwingWidgetPanelFactory implements
	WidgetPanelFactory<SwingWidget>
{

	@Override
	public <C> WidgetPanel<C> create(final StructInstance<C> struct,
		final List<? extends SwingWidget> widgets)
	{
		return new WidgetPanel<>(struct, widgets);
	}

	@Override
	public Class<SwingWidget> widgetType() {
		return SwingWidget.class;
	}

	// -- Helper classes --

	public class WidgetPanel<C> extends AbstractWidgetPanel<C> implements
		UIComponent<JPanel>
	{

		private final List<? extends SwingWidget> widgets;
		private JPanel panel;

		public WidgetPanel(final StructInstance<C> struct,
			final List<? extends SwingWidget> widgets)
		{
			super(struct);
			this.widgets = widgets;
		}

		@Override
		public JPanel getComponent() {
			if (panel != null) return panel;

			panel = new JPanel();
			final MigLayout layout =
					new MigLayout("fillx,wrap 2", "[right]10[fill,grow]");
			panel.setLayout(layout);

			for (final SwingWidget widget : widgets) {
				// add widget to panel
				final String label = Widgets.label(widget);
				if (label != null) {
					// widget is prefixed by a label
					final JLabel l = new JLabel(label);
					final String desc = Widgets.description(widget);
					if (desc != null && !desc.isEmpty()) l.setToolTipText(desc);
					panel.add(l);
					panel.add(widget.getComponent());
				}
				else {
					// widget occupies entire row
					getComponent().add(widget.getComponent(), "span");
				}
			}

			return panel;
		}

		@Override
		public Class<JPanel> getComponentType() {
			return JPanel.class;
		}
	}
}