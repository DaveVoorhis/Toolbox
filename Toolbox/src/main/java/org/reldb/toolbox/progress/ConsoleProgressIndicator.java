package org.reldb.toolbox.progress;

/**
 * A ProgressIndicator that outputs to the console.
 */
public class ConsoleProgressIndicator extends StandardProgressIndicator {
    /**
     * Constructor.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     * @param messageGenerator Lambda expression that defines the progress message.
     */
    public ConsoleProgressIndicator(String messagePrefix, ProgressIndicatorMessage messageGenerator) {
        super(messagePrefix, new ConsoleProgressIndicatorDisplay(), messageGenerator);
    }

    /**
     * Constructor.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     */
    public ConsoleProgressIndicator(String messagePrefix) {
        this(messagePrefix, new EnglishProgressIndicatorMessage());
    }

    /**
     * Constructor for console display without message prefix.
     */
    public ConsoleProgressIndicator() {
        this("");
    }
}
