package org.reldb.toolbox.progress;

/**
 * A ProgressIndicatorDisplay that emits to the console.
 */
public class ConsoleProgressIndicatorDisplay implements ProgressIndicatorDisplay {
    @Override
    public void display(StandardProgressIndicator progressIndicator) {
        System.out.println(progressIndicator.getProgressMessage());
    }
}
