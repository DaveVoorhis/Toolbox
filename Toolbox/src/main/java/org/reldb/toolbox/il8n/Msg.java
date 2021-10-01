package org.reldb.toolbox.il8n;

import java.util.Vector;
import java.util.stream.Stream;

/**
 * Represent a translatable message specified as a parametrised format string per java.text.MessageFormat.
 */
public class Msg {
    private static Vector<Msg> msgs = new Vector<>();

    /**
     * Get a Stream of all registered FormatS.
     *
     * @return Stream of Format.
     */
    public static Stream<Msg> getMsgs() {
        return msgs.stream();
    }

    /** Format specification per java.text.MessageFormat. */
    public final String formatSpec;

    /**
     * Define a format specification per java.text.MessageFormat.
     *
     * @param formatSpec Format specification per java.text.MessageFormat.
     */
    public Msg(String formatSpec) {
        this.formatSpec = formatSpec;
        msgs.add(this);
    }

    public String toString() {
        return formatSpec;
    }
}
