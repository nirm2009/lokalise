import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale locale_it_IT = new Locale("it", "IT");
        Locale locale_ru_RU = new Locale("ru", "RU");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle", locale_it_IT);

        System.out.println(resourceBundle.getString("welcome"));
    }
}
