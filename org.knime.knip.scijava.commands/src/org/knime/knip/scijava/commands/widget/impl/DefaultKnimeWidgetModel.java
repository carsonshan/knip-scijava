package org.knime.knip.scijava.commands.widget.impl;

import java.util.List;

import org.knime.core.node.defaultnodesettings.SettingsModel;
import org.knime.knip.scijava.commands.settings.NodeSettingsService;
import org.knime.knip.scijava.commands.widget.DialogInputWidgetModel;
import org.scijava.Context;
import org.scijava.module.Module;
import org.scijava.module.ModuleItem;
import org.scijava.plugin.Parameter;
import org.scijava.widget.DefaultWidgetModel;
import org.scijava.widget.InputPanel;

/**
 * Default implementation of DialoginputWidgetModel.
 *
 * @author Jonathan Hale (University of Konstanz)
 */
public class DefaultKnimeWidgetModel extends DefaultWidgetModel implements DialogInputWidgetModel {

	@Parameter
	private NodeSettingsService m_settingsService;
	
	public DefaultKnimeWidgetModel(Context context,
			InputPanel<?, ?> inputPanel, Module module, ModuleItem<?> item,
			List<?> objectPool) {
		super(context, inputPanel, module, item, objectPool);
		
		m_settingsService.createSettingsModel(item);
		updateToSettingsModel();
	}
	
	@Override
	public void updateModel() {
		updateToSettingsModel();
	}
	
	@Override
	public void setValue(Object value) {
		super.setValue(value);
		
		// keep track of the values, update settings model
		m_settingsService.setValue(getItem(), value);
	}
	
	@Override
	public SettingsModel getSettingsModel() {
		return m_settingsService.getSettingsModel(getItem());
	}
	
	@Override
	public void updateToSettingsModel() {
		super.setValue(m_settingsService.getValue(getItem()));
	}
	
}