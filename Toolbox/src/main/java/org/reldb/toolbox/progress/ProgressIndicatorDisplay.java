package org.reldb.toolbox.progress;

@FunctionalInterface
public interface ProgressIndicatorDisplay {
    void display(ProgressIndicatorCore core);
}
