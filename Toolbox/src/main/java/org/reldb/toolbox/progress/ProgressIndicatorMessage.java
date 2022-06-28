package org.reldb.toolbox.progress;

/**
 * Generator of progress indicator messages.
 */
@FunctionalInterface
public interface ProgressIndicatorMessage {
    /**
     * Given a progress indicator, return a message describing its current state.
     *
     * @param progressIndicator The ProgressIndicator.
     * @return A message describing the ProgressIndicator's current state.
     */
    String generate(StandardProgressIndicator progressIndicator);
}
