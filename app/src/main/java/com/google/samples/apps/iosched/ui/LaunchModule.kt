package com.google.samples.apps.iosched.ui

import androidx.lifecycle.ViewModel
import com.google.samples.apps.shared.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class LaunchModule {
    @Binds
    @IntoMap
    @ViewModelKey(LaunchViewModel::class)
    internal abstract fun bindLaunchViewModel(viewModel: LaunchViewModel): ViewModel
}