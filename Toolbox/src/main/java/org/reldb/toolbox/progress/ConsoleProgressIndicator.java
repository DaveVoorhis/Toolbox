package org.reldb.toolbox.progress;

/**
 * A ProgressIndicator that outputs to the console.
 */
public class ConsoleProgressIndicator extends ProgressIndicatorCore {
    /**
     * Constructor.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     */
    public ConsoleProgressIndicator(String messagePrefix) {
        super(messagePrefix);
    }

    /**
     * Constructor.
     */
    public ConsoleProgressIndicator() {
        super();
    }
}
