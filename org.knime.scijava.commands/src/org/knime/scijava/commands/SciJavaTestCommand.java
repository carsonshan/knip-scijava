
package org.knime.scijava.commands;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, headless = true, label = "Test Command")
public class SciJavaTestCommand implements Command {

    @Parameter
    private MultiOutputListener rowOutput;

    @Parameter(label = "From Text")
    private String fromText;

    @Parameter(label = "From Int")
    private int fromInt;

    @Parameter(type = ItemIO.OUTPUT, label = "Output Int")
    private int outInt;

    @Override
    public void run() {

        for (int i = 0; i < fromInt; i++) {
            outInt = i;
            rowOutput.notifyListener();
        }

    }

}
