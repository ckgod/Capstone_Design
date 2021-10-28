package com.ckg.appletree.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ckg.appletree.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    companion object {
        const val TAG = "SplashActivity"
    }
}