package com.google.samples.apps.iosched.ui

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity

class MainActivity: DaggerAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "main", Toast.LENGTH_LONG).show()
    }
}