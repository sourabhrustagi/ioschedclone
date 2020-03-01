package com.google.samples.apps.iosched.di

import android.content.Context
import com.google.samples.apps.iosched.MainApplication
import com.google.samples.apps.shared.data.prefs.PreferenceStorage
import com.google.samples.apps.shared.data.prefs.SharedPreferenceStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providesPreferenceStorage(context: Context): PreferenceStorage =
        SharedPreferenceStorage(context)
}