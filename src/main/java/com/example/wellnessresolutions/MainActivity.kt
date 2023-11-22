package com.example.wellnessresolutions

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.Manifest
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        // Check for the permission
        if (!activityRecognitionPermissionApproved()) {
            // Request the permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                PERMISSION_REQUEST_ACTIVITY_RECOGNITION
            )
        }
    }

    // Reviews Activity Recognition permission checking.
    //Source: https://developer.android.com/codelabs/android-sleep-api#2
    private fun activityRecognitionPermissionApproved(): Boolean {
        return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACTIVITY_RECOGNITION
        )
    }

    companion object {
        private const val PERMISSION_REQUEST_ACTIVITY_RECOGNITION = 1
    }
}