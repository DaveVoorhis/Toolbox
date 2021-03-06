package org.reldb.toolbox.il8n;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

/**
 * Message registry.
 */
public class Str {

    private static String displayLanguage = Locale.getDefault().getDisplayLanguage();

    private static final Vector<String> strings = new Vector<>();
    private static final Map<String, Map<String, String>> translations = new HashMap<>();

    /**
     * Set the display language. Default is Locale.getDefault().getDisplayLanguage().
     *
     * @param displayLanguage Language identifier, of the kind returned by Locale.getDefault().getDisplayLanguage().
     */
    public static void setDisplayLanguage(String displayLanguage) {
        Str.displayLanguage = displayLanguage;
    }

    /**
     * Get the display language.
     *
     * @return Language identifier, of the kind returned by Locale.getDefault().getDisplayLanguage().
     */
    public static String getDisplayLanguage() {
        return displayLanguage;
    }

    /**
     * Set the source format string to target format string map for a given language.
     *
     * @param language Language identifier, of the kind returned by Locale.getDefault().getDisplayLanguage().
     * @param sourceFormatToTranslatedFormat A Map from source format strings defined in code to translated strings
     *                                   in the specified language.
     */
    public static void addTranslations(String language, Map<String, String> sourceFormatToTranslatedFormat) {
        translations.put(language, sourceFormatToTranslatedFormat);
    }

    /**
     * Add a format string translation for a given language.
     *
     * @param language Language identifier, of the kind returned by Locale.getDefault().getDisplayLanguage().
     * @param sourceFormat Source format string, of the kind used by java.text.MessageFormat.
     * @param translatedFormat Translated format string, of the kind used by java.text.MessageFormat.
     */
    public static void addTranslation(String language, String sourceFormat, String translatedFormat) {
        var formatMap = translations.get(language);
        if (formatMap == null) {
            formatMap = new HashMap<>();
            formatMap.put(sourceFormat, translatedFormat);
        }
        translations.put(language, formatMap);
    }

    /**
     * Get a translation of a source format string for a given language.
     *
     * @param language Language identifier, of the kind returned by Locale.getDefault().getDisplayLanguage().
     * @param sourceFormat Source format string, of the kind used by java.text.MessageFormat.
     * @return Translated format string, of the kind used by java.text.MessageFormat.
     */
    public static String getTranslation(String language, String sourceFormat) {
        var formatMap = translations.get(language);
        if (formatMap == null)
            return sourceFormat;
        var translation = formatMap.get(sourceFormat);
        return translation == null
                ? sourceFormat
                : translation;
    }

    /**
     * Get a translation of a source format string for language returned by getDisplayLanguage().
     *
     * @param sourceFormat Source format string, of the kind used by java.text.MessageFormat.
     * @return Translated format string, of the kind used by java.text.MessageFormat.
     */
    public static String getTranslation(String sourceFormat) {
        return getTranslation(getDisplayLanguage(), sourceFormat);
    }

    /**
     * Given a message containing a format specification per java.text.MessageFormat and optional
     * arguments, return the string as its locale-specific, possibly-translated message.
     *
     * @param formatSpecification Static specification of messagee format.
     * @param arguments Message arguments.
     * @return Displayable message.
     */
    public static String ing(Msg formatSpecification, Object ... arguments) {
        var sourceFormat = formatSpecification.formatSpec;
        var translatedFormat = getTranslation(sourceFormat);
        return
            (formatSpecification.location != null
                ? formatSpecification.location + ": "
                : "")
            + MessageFormat.format(translatedFormat, arguments);
    }

}
