package com.google.samples.apps.iosched.ui.onboarding

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.updatePadding
import androidx.lifecycle.ViewModelProvider
import com.google.samples.apps.iosched.R
import com.google.samples.apps.shared.di.IOSchedViewModelFactory
import com.google.samples.apps.shared.util.doOnApplyWindowInsets
import com.google.samples.apps.shared.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OnboardingActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewModel = viewModelProvider(viewModelFactory)

        val decor = window.decorView
        val flags = decor.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        decor.systemUiVisibility = flags

        val container: FrameLayout = findViewById(R.id.fragment_container)
        container.doOnApplyWindowInsets { v, insets, padding ->
            v.updatePadding(top = padding.top + insets.systemWindowInsetTop)
        }
    }
}