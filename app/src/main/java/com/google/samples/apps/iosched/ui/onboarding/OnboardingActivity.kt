package com.google.samples.apps.iosched.ui.onboarding

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity

class OnboardingActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "onboarding", Toast.LENGTH_LONG).show()
    }
}