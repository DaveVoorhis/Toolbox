package org.reldb.toolbox.progress;

/**
 * A ProgressIndicator that generates and outputs progress updates via specified lambda expressions.
 */
public class StandardProgressIndicator implements ProgressIndicator {
    private final String messagePrefix;
    private final ProgressIndicatorDisplay display;
    private final ProgressIndicatorMessage messageGenerator;

    private int steps = 0;
    private int position = 0;
    private String lastMessage = "";
    private int precision = 2;

    /**
     * Constructor.
     *
     * @param messagePrefix This will be prefixed to all outputted messages.
     * @param display Lambda definition of display mechanism.
     * @param messageGenerator Lambda definition of message generator.
     */
    public StandardProgressIndicator(String messagePrefix,
                                     ProgressIndicatorDisplay display,
                                     ProgressIndicatorMessage messageGenerator) {
        this.messagePrefix = messagePrefix;
        this.display = display;
        this.messageGenerator = messageGenerator;
    }

    /**
     * Set progress message percent precision.
     *
     * @param precision Decimal precision of percentage. Default is 2 decimal places.
     */
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    /**
     * Get progress message percent precision.
     *
     * @return Decimal precision of percentage. Default is 2 decimal places.
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * Get the message prefix. Set in the constructor.
     *
     * @return The message prefix.
     */
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

    /**
     * Get percent progress as a float.
     *
     * @return Percent progress.
     */
    public float getPercent() {
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

    /**
     * Get the current progress as a percentage.
     *
     * @return Current progress message.
     */
    public String getProgressMessage() {
        return messageGenerator.generate(this);
    }

    @Override
    public void move(int step, String additionalInformation) {
        position = step;
        lastMessage = additionalInformation;
        display.display(this);
    }
}
