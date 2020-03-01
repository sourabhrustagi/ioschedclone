package com.google.samples.apps.iosched.di

import com.google.samples.apps.iosched.ui.LaunchModule
import com.google.samples.apps.iosched.ui.LauncherActivity
import com.google.samples.apps.shared.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinding {
    @ActivityScope
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    internal abstract fun launcherActivity(): LauncherActivity
}