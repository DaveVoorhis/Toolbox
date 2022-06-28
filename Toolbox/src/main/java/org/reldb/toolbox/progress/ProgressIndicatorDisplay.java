package org.reldb.toolbox.progress;

/**
 * Used to create lambda expressions that emit the current progress of a ProgressIndicator, typically
 * when the ProgressIndicator's move(...) method is invoked.
 */
@FunctionalInterface
public interface ProgressIndicatorDisplay {
    /**
     * Invoked in response to a ProgressIndicator move(...) invocation.
     *
     * @param progressIndicator The ProgressIndicatorCore whose status we wish to display.
     */
    void display(StandardProgressIndicator progressIndicator);
}
