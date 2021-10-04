package org.reldb.toolbox.il8n;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStrAndMsg {
    private final Msg msg01 = new Msg("This {0} is {1} a {2} message.", "Location");

    @Test
    public void Test01() {
        assertEquals("Location: This message is definitely a test message.", Str.ing(msg01, "message", "definitely", "test"));
    }
}
