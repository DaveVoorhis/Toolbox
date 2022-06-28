package org.reldb.toolbox.progress;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProgress {
    @Test
    void testSimpleNumbers() {
        var expectedMessages = new ExpectedMessageProvider(
                "PrefixSuffix: 0.00% complete.",
                "PrefixSuffix: 10.00% complete.",
                "PrefixSuffix: 20.00% complete.",
                "PrefixSuffix: 30.00% complete.",
                "PrefixSuffix: 40.00% complete.",
                "PrefixSuffix: 50.00% complete.",
                "PrefixSuffix: 60.00% complete.",
                "PrefixSuffix: 70.00% complete.",
                "PrefixSuffix: 80.00% complete.",
                "PrefixSuffix: 90.00% complete.",
                "PrefixSuffix: 100.00% complete."
        );
        var generatedMessages = new ArrayList<String>();
        var progress = new StandardProgressIndicator("Prefix",
                core -> generatedMessages.add(core.getProgressMessage()),
                new EnglishProgressIndicatorMessage());
        progress.initialise(100);
        for (int step = 0; step <= 100; step += 10) {
            progress.move(step, "Suffix");
        }
        generatedMessages
                .forEach(generatedMessage -> assertEquals(generatedMessage, expectedMessages.getNextMessage()));
        assertTrue(expectedMessages.gotAllMessages());
    }

    @Test
    void testPrecision() {
        var expectedMessages = new ExpectedMessageProvider(
                "PrefixSuffix: 0.000% complete.",
                "PrefixSuffix: 33.333% complete.",
                "PrefixSuffix: 66.667% complete.",
                "PrefixSuffix: 100.000% complete."
        );
        var generatedMessages = new ArrayList<String>();
        var progress = new StandardProgressIndicator("Prefix",
                core -> generatedMessages.add(core.getProgressMessage()),
                new EnglishProgressIndicatorMessage());
        progress.setPrecision(3);
        progress.initialise(3);
        for (int step = 0; step <= 3; step++) {
            progress.move(step, "Suffix");
        }
        generatedMessages
                .forEach(generatedMessage -> assertEquals(generatedMessage, expectedMessages.getNextMessage()));
        assertTrue(expectedMessages.gotAllMessages());
    }

}
