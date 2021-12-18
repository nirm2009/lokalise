// On the disk to Over The Air /////////////////////////////////////////////////////////////////
package com.lokalise.android_i18n;

import android.app.Application;

import com.lokalise.sdk.Lokalise;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Lokalise.init(this, "add-your-sdk-token-here",
                "add-your-project-id-here");

        Lokalise.updateTranslations();
    }
}
// /////////////////////////////////////////////////////////////////////////////////////////////