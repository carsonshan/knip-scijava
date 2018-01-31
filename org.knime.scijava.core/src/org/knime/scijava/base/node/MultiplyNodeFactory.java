package org.knime.scijava.base.node;

import java.util.function.Function;

import org.knime.core.node.NodeDialogPane;
import org.knime.core.node.NodeFactory;
import org.knime.core.node.NodeView;
import org.knime.scijava.base.MultiplicationFunction;
import org.scijava.param2.ValidityException;

public class MultiplyNodeFactory extends NodeFactory<RowToRowFunctionNodeModel<?, ?>> {

	private final Function<?, ?> m_function = new MultiplicationFunction();

	public MultiplyNodeFactory() {
		// function will be served from the outside, later
	}

	@Override
	public RowToRowFunctionNodeModel<?, ?> createNodeModel() {
		try {
			return new RowToRowFunctionNodeModel<>(m_function);
		} catch (final ValidityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected int getNrNodeViews() {
		return 0;
	}

	@Override
	public NodeView<RowToRowFunctionNodeModel<?, ?>> createNodeView(final int viewIndex,
			final RowToRowFunctionNodeModel<?, ?> nodeModel) {
		return null;
	}

	@Override
	protected boolean hasDialog() {
		return true;
	}

	@Override
	protected NodeDialogPane createNodeDialogPane() {
		try {
			return new FunctionNodeDialog<>(m_function);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
