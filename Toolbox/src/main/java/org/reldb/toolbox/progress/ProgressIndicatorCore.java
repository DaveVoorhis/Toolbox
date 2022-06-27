package org.reldb.toolbox.progress;

/**
 * A ProgressIndicator that outputs to the console.
 */
public class ProgressIndicatorCore implements ProgressIndicator {
    private final String messagePrefix;
    private final ProgressIndicatorDisplay display;

    private int steps = 0;
    private int position = 0;
    private String lastMessage = "";
    private int precision = 2;

    /**
     * Constructor.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     * @param display Lambda definition of display mechanism.
     */
    public ProgressIndicatorCore(String messagePrefix, ProgressIndicatorDisplay display) {
        this.messagePrefix = messagePrefix;
        this.display = display;
    }

    /**
     * Constructor for console display.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     */
    public ProgressIndicatorCore(String messagePrefix) {
        this(messagePrefix, core -> System.out.println(core.getProgressMessage()));
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    /**
     * Constructor for console display without message prefix.
     */
    public ProgressIndicatorCore() {
        this("");
    }

    public String getMessagePrefix() {
        return messagePrefix;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getLastMessage() {
        return lastMessage;
    }

    private float getPercent() {
        return (float)getPosition() / (float)getSteps() * (float)100.0;
    }

    @Override
    public void initialise(int steps) {
        this.steps = steps;
        this.position = 0;
    }

    @Override
    public int getSteps() {
        return steps;
    }

    public String getProgressMessage() {
        final var fmt = "%s%s: %." + getPrecision() + "f%% complete.";
        return String.format(fmt,
                getMessagePrefix() != null ? getMessagePrefix() : "",
                getLastMessage() != null ? getLastMessage() : "",
                getPercent());
    }

    @Override
    public void move(int step, String additionalInformation) {
        position = step;
        lastMessage = additionalInformation;
        display.display(this);
    }
}
