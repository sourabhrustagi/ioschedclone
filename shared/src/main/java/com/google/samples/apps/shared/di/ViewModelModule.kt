package com.google.samples.apps.shared.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: IOSchedViewModelFactory):
            ViewModelProvider.Factory
}