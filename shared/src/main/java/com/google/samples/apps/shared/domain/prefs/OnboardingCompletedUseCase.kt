package com.google.samples.apps.shared.domain.prefs

import com.google.samples.apps.shared.data.prefs.PreferenceStorage
import com.google.samples.apps.shared.domain.UseCase
import javax.inject.Inject

/**
 * Returns whether onboarding has been completed.
 */
open class OnboardingCompletedUseCase @Inject constructor(
    private val preferenceStorage: PreferenceStorage
) : UseCase<Boolean, Unit>() {
    override fun execute(parameters: Boolean) {
        preferenceStorage.onboardingCompleted = parameters
    }
}