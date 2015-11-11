package org.knime.scijava.commands.adapter.basic;

import org.knime.core.data.def.IntCell;
import org.knime.scijava.commands.adapter.AbstractOutputAdapter;
import org.knime.scijava.commands.adapter.OutputAdapter;
import org.scijava.plugin.Plugin;

/**
 * Adapter for Integer to {@link IntCell}.
 *
 * @author Jonathan Hale (University of Konstanz)
 *
 */
@Plugin(type = OutputAdapter.class)
public class IntOutputAdapter extends AbstractOutputAdapter<Integer, IntCell> {

	@Override
	public IntCell createCell(final Integer o) {
		return new IntCell(o);
	}

	@Override
	public Class<IntCell> getOutputType() {
		return IntCell.class;
	}

	@Override
	public Class<Integer> getInputType() {
		return Integer.class;
	}

}
