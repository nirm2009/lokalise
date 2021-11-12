import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.util.ULocale;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        pluralizeUsingMessageFormat();
//        pluralizeWithExternalPluralPattern();
//        pluralizeUsingMessageFormatArguments();
    }

    private static void pluralizeUsingMessageFormat() {
        MessageFormat pluralMessageFormat = new MessageFormat(
                                        "{quantity, plural, " +
                                                "=0{There are no apples.}" +
                                                "=1{There is one apple.}" +
                                                "other{There are # apples.}" +
                                                "}",
                                                ULocale.ENGLISH);

// Pluralize in French locale //////////////////////////////////////////
//        MessageFormat pluralMessageFormat = new MessageFormat(
//                                        "{quantity, plural, " +
//                                                "=0{Il n'y a pas de pommes.}" +
//                                                "=1{Il y a une pomme.}" +
//                                                "other{Il y a # pommes.}" +
//                                                "}",
//                                                ULocale.FRENCH);
// /////////////////////////////////////////////////////////////////////

        Map patternArgs = new HashMap();
        patternArgs.put("quantity", 0);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 1);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 2);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 5);
        System.out.println(pluralMessageFormat.format(patternArgs));
    }

    private static void pluralizeWithExternalPluralPattern() {
        ResourceBundle resourceBundleEn = ResourceBundle.getBundle("pattern", Locale.ENGLISH);
        String patternEn = resourceBundleEn.getString("applecount");
        MessageFormat pluralMessageFormat = new MessageFormat(patternEn, ULocale.ENGLISH);

// Pluralize in French locale //////////////////////////////////////////
//        ResourceBundle resourceBundleFr = ResourceBundle.getBundle("pattern", Locale.FRENCH);
//        String patternFr = resourceBundleFr.getString("applecount");
//        MessageFormat pluralMessageFormat = new MessageFormat(patternFr, ULocale.FRENCH);
// /////////////////////////////////////////////////////////////////////

        Map patternArgs = new HashMap();
        patternArgs.put("quantity", 0);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 1);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 2);
        System.out.println(pluralMessageFormat.format(patternArgs));
        patternArgs.put("quantity", 5);
        System.out.println(pluralMessageFormat.format(patternArgs));
    }

// MessageFormat arguments as placeholders /////////////////////////////////////////////////////
    private static void pluralizeUsingMessageFormatArguments() {
        MessageFormat pluralMessageFormatWithArgs = new MessageFormat(
                "{quantity, plural, " +
                        "=0{There are no apples in the {location} farm.}" +
                        "=1{There is one apple in the {location} farm.}" +
                        "other{There are # apples in the {location} farm.}" +
                        "}",
                ULocale.ENGLISH);

        Map patternArgs = new HashMap();
        patternArgs.put("quantity", 0);
        patternArgs.put("location", "Normandy");
        System.out.println(pluralMessageFormatWithArgs.format(patternArgs));
        patternArgs.put("quantity", 2);
        patternArgs.put("location", "Washington");
        System.out.println(pluralMessageFormatWithArgs.format(patternArgs));
    }
// /////////////////////////////////////////////////////////////////////////////////////////////
}
