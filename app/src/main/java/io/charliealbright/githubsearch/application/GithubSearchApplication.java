package io.charliealbright.githubsearch.application;

import android.app.Application;

import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by Charlie on 5/5/2017.
 */

public class GithubSearchApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
