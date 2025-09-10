package com.example.customtoggle.demo.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.R
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class FeaturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_features)

        bindToggle(R.id.toggle_gps, R.id.text_gps, "GPS Tracking", ToggleType.GPS_TRACKING, false)
        bindToggle(R.id.toggle_sync, R.id.text_sync, "Background Sync", ToggleType.BACKGROUND_SYNC, false)
        bindToggle(R.id.toggle_backup, R.id.text_backup, "Cloud Backup", ToggleType.CLOUD_BACKUP, false)
        bindToggle(R.id.toggle_ads, R.id.text_ads, "Ads Personalization", ToggleType.ADS_PERSONALIZATION, false)
        bindToggle(R.id.toggle_remember, R.id.text_remember, "Remember Me", ToggleType.REMEMBER_ME, false)
        bindToggle(R.id.toggle_offline, R.id.text_offline, "Offline Mode", ToggleType.OFFLINE_MODE, false)
    }

    private fun bindToggle(
        toggleId: Int,
        textId: Int,
        label: String,
        type: ToggleType,
        initialState: Boolean
    ) {
        val toggle = findViewById<CustomToggle>(toggleId)
        val text = findViewById<TextView>(textId)

        // assign correct type
        toggle.toggleType = type

        // set initial state
        toggle.setInitialState(initialState)

        // update text dynamically when toggled
        toggle.setOnToggleChangedListener { isOn ->
            val statusText = when (label) {
                "GPS Tracking" -> if (isOn) "GPS Tracking Enabled" else "GPS Tracking Disabled"
                "Background Sync" -> if (isOn) "Background Sync Enabled" else "Background Sync Disabled"
                "Cloud Backup" -> if (isOn) "Cloud Backup Enabled" else "Cloud Backup Disabled"
                "Ads Personalization" -> if (isOn) "Ads Personalization Enabled" else "Ads Personalization Disabled"
                "Remember Me" -> if (isOn) "Remember Me Enabled" else "Remember Me Disabled"
                "Offline Mode" -> if (isOn) "Offline Mode Enabled" else "Offline Mode Disabled"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // set initial text
        text.text = when (label) {
            "GPS Tracking" -> if (initialState) "GPS Tracking Enabled" else "GPS Tracking Disabled"
            "Background Sync" -> if (initialState) "Background Sync Enabled" else "Background Sync Disabled"
            "Cloud Backup" -> if (initialState) "Cloud Backup Enabled" else "Cloud Backup Disabled"
            "Ads Personalization" -> if (initialState) "Ads Personalization Enabled" else "Ads Personalization Disabled"
            "Remember Me" -> if (initialState) "Remember Me Enabled" else "Remember Me Disabled"
            "Offline Mode" -> if (initialState) "Offline Mode Enabled" else "Offline Mode Disabled"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}