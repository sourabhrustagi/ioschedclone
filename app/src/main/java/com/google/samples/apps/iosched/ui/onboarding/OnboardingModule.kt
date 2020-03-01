package com.google.samples.apps.iosched.ui.onboarding

import androidx.lifecycle.ViewModel
import com.google.samples.apps.shared.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class OnboardingModule {
    @Binds
    @IntoMap
    @ViewModelKey(OnboardingViewModel::class)
    internal abstract fun bindOnboardingViewModel(viewModel: OnboardingViewModel): ViewModel
}