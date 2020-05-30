package res;

import java.util.ListResourceBundle;

public class Bundle_it_IT extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", "Ciao"},
                {"ourfeatures", new String[] {"Traduzione Collaborativa", "Gestione del flusso di lavoro di localizzazione", "Automazione del processo di localizzazione"}}
        };
    }
}