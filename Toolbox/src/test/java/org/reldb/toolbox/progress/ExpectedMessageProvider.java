package org.reldb.toolbox.progress;

public class ExpectedMessageProvider {
    private final String[] messages;
    private int index;

    public ExpectedMessageProvider(String... messages) {
        this.messages = messages;
        index = 0;
    }

    public String getNextMessage() {
        return messages[index++];
    }

    public boolean gotAllMessages() {
        return index == messages.length;
    }
}
