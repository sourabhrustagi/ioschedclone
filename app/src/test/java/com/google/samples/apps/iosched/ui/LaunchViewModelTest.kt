package com.google.samples.apps.iosched.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidtest_shared.LiveDataTestUtil
import com.google.samples.apps.iosched.test.util.SyncTaskExecutorRule
import com.google.samples.apps.shared.data.prefs.PreferenceStorage
import com.google.samples.apps.shared.domain.prefs.OnboardingCompletedUseCase
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class LaunchViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var syncTaskExecutorRule = SyncTaskExecutorRule()

    @Test
    fun notCompletedOnboarding_navigateToOnboarding() {
        val prefs = mock<PreferenceStorage> {
            on { onboardingCompleted }.doReturn(false)
        }

        val onboardingCompletedUseCase = OnboardingCompletedUseCase(prefs)
        val viewModel = LaunchViewModel(onboardingCompletedUseCase)

        val navigateEvent = LiveDataTestUtil.getValue(viewModel.launchDestination)
        assertEquals(LaunchDestination.ONBOARDING, navigateEvent?.getContentIfNotHandled())
    }

    @Test
    fun hasCompletedOnboarding_navigateToMainActivity() {
        val prefs = mock<PreferenceStorage> {
            on { onboardingCompleted }.doReturn(true)
        }

        val onboardingCompletedUseCase = OnboardingCompletedUseCase(prefs)
        val viewModel = LaunchViewModel(onboardingCompletedUseCase)

        val navigateEvent = LiveDataTestUtil.getValue(viewModel.launchDestination)
        assertEquals(LaunchDestination.MAIN_ACTIVITY, navigateEvent?.getContentIfNotHandled())
    }
}