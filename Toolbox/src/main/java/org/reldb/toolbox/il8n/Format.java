package org.reldb.toolbox.il8n;

import java.util.Vector;
import java.util.stream.Stream;

/**
 * Represent a translatable message specified as a parametrised format string per java.text.MessageFormat,
 * and a location.
 */
public class Format {
    private static Vector<Format> formats = new Vector<>();

    /**
     * Get a Stream of all registered FormatS.
     *
     * @return Stream of Format.
     */
    public static Stream<Format> getFormats() {
        return formats.stream();
    }

    /** Format specification per java.text.MessageFormat. */
    public final String formatSpec;

    /**
     * Define a format specification per java.text.MessageFormat.
     *
     * @param formatSpec Format specification per java.text.MessageFormat.
     */
    public Format(String formatSpec) {
        this.formatSpec = formatSpec;
        formats.add(this);
    }

    public String toString() {
        return formatSpec;
    }
}
