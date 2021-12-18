package com.lokalise.android_i18n;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.lokalise.android_i18n.utils.ContextUtils;
import com.lokalise.sdk.Lokalise;
import com.lokalise.sdk.LokaliseContextWrapper;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        // Change Application Locale Programmatically ////////////////////////////////////////////////////
//        Locale localeToSwitchTo = new Locale("ru");
//        ContextWrapper localeUpdatedContext = ContextUtils.updateLocale(newBase, localeToSwitchTo);
//        super.attachBaseContext(localeUpdatedContext);
        // ///////////////////////////////////////////////////////////////////////////////////////////////

        // On the disk to Over The Air //////////////////////////////////////////////
        super.attachBaseContext(LokaliseContextWrapper.wrap(newBase));
        // //////////////////////////////////////////////////////////////////////////
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);

        TextView textView = findViewById(R.id.test_text_view);
        textView.setText(R.string.my_string_name);

        // How to Pluralize Nouns /////////////////////////////////////////////////////////////////////
//        Resources res = getResources();
//        TextView pluralViewOne = findViewById(R.id.plural_view_one);
//        String quantityStringFor1 = res.getQuantityString(R.plurals.my_cats, 1, 1);
//        pluralViewOne.setText(quantityStringFor1);
//
//        TextView pluralViewFew = findViewById(R.id.plural_view_few);
//        String quantityStringFor2 = res.getQuantityString(R.plurals.my_cats, 2, 2);
//        pluralViewFew.setText(quantityStringFor2);
//
//        TextView pluralViewMany = findViewById(R.id.plural_view_many);
//        String quantityStringFor5 = res.getQuantityString(R.plurals.my_cats, 5, 5);
//        pluralViewMany.setText(quantityStringFor5);
        // ////////////////////////////////////////////////////////////////////////////////////////////

        // What about Date and Time? ////////////////////////////////////////////////////////////
        Date currentDateTime = new Date();

        TextView localizedDateTimeView = findViewById(R.id.localized_date_time_view);
        localizedDateTimeView.setText(DateFormat.getDateTimeInstance().format(currentDateTime));
        // //////////////////////////////////////////////////////////////////////////////////////
    }
}