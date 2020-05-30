package res;

import java.util.ListResourceBundle;

public class Bundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", "Hello"},
                {"ourfeatures", new String[] {"Collaborative Translation", "Localization Workflow Management", "Localization Process Automation"}}
        };
    }
}