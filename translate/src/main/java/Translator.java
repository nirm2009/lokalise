import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Translator {
    public static void main(String[] args) {
        //Initiate google cloud translation service
        Translate translate = TranslateOptions.getDefaultInstance().getService(); //1

        String textToTranslate = "Localization in Java is fun";

        //Perform translation
        Translation translation = translate.translate(textToTranslate,
                                                      TranslateOption.sourceLanguage("en"), //2
                                                      TranslateOption.targetLanguage("it"));
        String translatedText = translation.getTranslatedText();

        System.out.println(translatedText);
    }
}
