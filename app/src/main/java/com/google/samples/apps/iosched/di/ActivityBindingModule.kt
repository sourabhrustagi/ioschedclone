package com.google.samples.apps.iosched.di

import com.google.samples.apps.iosched.ui.LaunchModule
import com.google.samples.apps.iosched.ui.LauncherActivity
import com.google.samples.apps.iosched.ui.MainActivity
import com.google.samples.apps.iosched.ui.MainActivityModule
import com.google.samples.apps.iosched.ui.onboarding.OnboardingActivity
import com.google.samples.apps.iosched.ui.onboarding.OnboardingModule
import com.google.samples.apps.shared.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    internal abstract fun launcherActivity(): LauncherActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            OnboardingModule::class
        ]
    )
    internal abstract fun onboardingActivity(): OnboardingActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity
}