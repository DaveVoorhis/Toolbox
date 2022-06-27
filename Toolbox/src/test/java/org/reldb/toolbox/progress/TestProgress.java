package org.reldb.toolbox.progress;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestProgress {
    @Test
    void testSimpleNumbers() {
        var generatedMessages = new ArrayList<String>();
        var progress = new ProgressIndicatorCore("Prefix",
                core -> generatedMessages.add(core.getProgressMessage()));
        progress.initialise(100);
        for (int step = 0; step <= 100; step += 10) {
            progress.move(step, "Suffix");
        }
        generatedMessages
                .forEach(System.out::println);
    }

    @Test
    void testPrecision() {
        var generatedMessages = new ArrayList<String>();
        var progress = new ProgressIndicatorCore("Prefix",
                core -> generatedMessages.add(core.getProgressMessage()));
        progress.initialise(3);
        for (int step = 0; step <= 3; step++) {
            progress.move(step, "Suffix");
        }
        generatedMessages
                .forEach(System.out::println);
    }

}
