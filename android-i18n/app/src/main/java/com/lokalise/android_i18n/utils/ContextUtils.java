package com.lokalise.android_i18n.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

public class ContextUtils extends ContextWrapper {
    public ContextUtils(Context base) {
        super(base);
    }

    public static ContextWrapper updateLocale(Context context, Locale localeToSwitchTo) {
        Resources resources = context.getResources();
        // TODO: ADD_TO_ARTICLE:Create a new configuration object using resource configuration on the give context
        //TODO: src : https://stackoverflow.com/questions/39705739/android-n-change-language-programmatically
        Configuration configuration = resources.getConfiguration();

        //TODO: look at deprecations section on Current for reasoning
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        //TODO: ADD_TO_ARTICLE: *mention usage of localeList in place of configuration.setLocale(localeToSwitchTo);*

            //TODO: ADD_TO_ARTICLE:Set a locale list containing the locale we plan to switch to
            LocaleList localeList = new LocaleList(localeToSwitchTo);
            //TODO: ADD_TO_ARTICLE: Sets the default locale for this instance of the JVM to the locale at the first index
            // on this list. Since there's only one locale present on our example, this will inadvertently set the locale
            // on localeToSwitchTo variable as the default locale.
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
        } else {
            configuration.locale = localeToSwitchTo;
        }

        //TODO: look at deprecations section on Current for reasoning
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            //TODO: ADD_TO_ARTICLE: Set the current context variable to a new Context object whose
            // resources are adjusted to match the given Configuration.
            context = context.createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }

        return new ContextUtils(context);
    }
}
