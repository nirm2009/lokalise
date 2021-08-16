import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        getCurrentDateDefaultTimeZone();
        getCurrentDateSpecificTimeZone();
        parseDateFromString();
        parseDateFromStringSpecificFormatter();
        formatLocalDateObjToLocalizedDateStr();
        getLocalizedStartOfDay();
    }

    private static void getCurrentDateDefaultTimeZone() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);
    }

    private static void getCurrentDateSpecificTimeZone() {
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        LocalDate currentDateTokyoTZ = LocalDate.now(tokyoZoneId);
        System.out.println("Current date in Tokyo: " + currentDateTokyoTZ);
    }

    private static void parseDateFromString() {
        //parse using default DateTimeFormatter.ISO_LOCAL_DATE
        String dateToParse = "2018-11-22";
        LocalDate parsedDate = LocalDate.parse(dateToParse);
        System.out.println("Parsed object type: " + parsedDate.getClass());
        System.out.println("Parsed date: " + parsedDate.toString());
    }

    private static void parseDateFromStringSpecificFormatter() {
        //parse US-localized date using specific DateTimeFormatter holding the US-localized date pattern
        String dateUSLocalized = "05/09/2021";
        DateTimeFormatter usDateFormatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        LocalDate parsedDate = LocalDate.parse(dateUSLocalized, usDateFormatter);
        System.out.println("Parsed date provided in US-localized date format: " + parsedDate);
    }

    private static void formatLocalDateObjToLocalizedDateStr() {
        //format LocalDate obj back to a string presenting the date in localized date formats
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter usDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        String usFormattedDate = currentDate.format(usDateFormatter);
        System.out.println("Current date in en-US date format: " + usFormattedDate);

        DateTimeFormatter frDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);
        String frFormattedDate = currentDate.format(frDateFormatter);
        System.out.println("Current date in fr-FR date format: " + frFormattedDate);
    }

    private static void getLocalizedStartOfDay() {
        LocalDate springForwardedDate = LocalDate.of(2022,3,13);
        ZonedDateTime startOfSpringForwardedDate = springForwardedDate.atStartOfDay(ZoneId.of("Cuba"));
        System.out.println("Start of day for +1 hour spring forwarded day (13-03-2022) in Cuba: " + startOfSpringForwardedDate);
        System.out.println("Day starts at " + startOfSpringForwardedDate.getHour());
    }
}

