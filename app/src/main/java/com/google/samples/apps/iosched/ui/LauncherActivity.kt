package com.google.samples.apps.iosched.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.samples.apps.iosched.ui.onboarding.OnboardingActivity
import com.google.samples.apps.shared.result.EventObserver
import com.google.samples.apps.shared.util.checkAllMatched
import com.google.samples.apps.shared.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LauncherActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LaunchViewModel = viewModelProvider(viewModelFactory)
        viewModel.launchDestination.observe(this, EventObserver { destination ->
            when (destination) {
                LaunchDestination.MAIN_ACTIVITY -> startActivity(
                    Intent(
                        this,
                        MainActivity::class.java
                    )
                )
                LaunchDestination.ONBOARDING -> startActivity(
                    Intent(
                        this,
                        OnboardingActivity::class.java
                    )
                )
            }.checkAllMatched
            finish()
        })
    }
}
