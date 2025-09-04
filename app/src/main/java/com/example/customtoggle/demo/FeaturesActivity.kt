package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class FeaturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_features)

        // GPS Tracking
        val toggleGps = findViewById<CustomToggle>(R.id.toggle_gps)
        val textGps = findViewById<TextView>(R.id.text_gps)
        toggleGps.setOnToggleChangedListener { isOn ->
            textGps.text = if (isOn) "GPS Tracking Enabled" else "GPS Tracking Disabled"
        }

        // Background Sync
        val toggleSync = findViewById<CustomToggle>(R.id.toggle_sync)
        val textSync = findViewById<TextView>(R.id.text_sync)
        toggleSync.setOnToggleChangedListener { isOn ->
            textSync.text = if (isOn) "Background Sync Enabled" else "Background Sync Disabled"
        }

        // Cloud Backup
        val toggleBackup = findViewById<CustomToggle>(R.id.toggle_backup)
        val textBackup = findViewById<TextView>(R.id.text_backup)
        toggleBackup.setOnToggleChangedListener { isOn ->
            textBackup.text = if (isOn) "Cloud Backup Enabled" else "Cloud Backup Disabled"
        }

        // Ads personalization
        val toggleAds = findViewById<CustomToggle>(R.id.toggle_ads)
        val textAds = findViewById<TextView>(R.id.text_ads)
        toggleAds.setOnToggleChangedListener { isOn ->
            textAds.text = if (isOn) "Ads Personalization Enabled" else "Ads Personalization Disabled"
        }

        // Remember me
        val toggleRemember = findViewById<CustomToggle>(R.id.toggle_remember)
        val textRemember = findViewById<TextView>(R.id.text_remember)
        toggleRemember.setOnToggleChangedListener { isOn ->
            textRemember.text = if (isOn) "Remember Me Enabled" else "Remember Me Disabled"
        }

        // Offline Mode
        val toggleOffline = findViewById<CustomToggle>(R.id.toggle_offline)
        val textOffline = findViewById<TextView>(R.id.text_offline)
        toggleOffline.setOnToggleChangedListener { isOn ->
            textOffline.text = if (isOn) "Offline Mode Enabled" else "Offline Mode Disabled"
        }
    }
}
