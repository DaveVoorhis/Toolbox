package org.reldb.toolbox.progress;

/**
 * Standard English progress indicator message generator.
 */
public class EnglishProgressIndicatorMessage implements ProgressIndicatorMessage {
    @Override
    public String generate(StandardProgressIndicator progressIndicator) {
        return String.format("%s%s: %." + progressIndicator.getPrecision() + "f%% complete.",
                progressIndicator.getMessagePrefix() != null ? progressIndicator.getMessagePrefix() : "",
                progressIndicator.getLastMessage() != null ? progressIndicator.getLastMessage() : "",
                progressIndicator.getPercent());
    }
}
