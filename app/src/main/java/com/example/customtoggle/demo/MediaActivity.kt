package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class MediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        // Autoplay
        val toggleAutoplay = findViewById<CustomToggle>(R.id.toggle_autoplay)
        val textAutoplay = findViewById<TextView>(R.id.text_autoplay)
        toggleAutoplay.setOnToggleChangedListener { isOn ->
            textAutoplay.text = if (isOn) "Autoplay Enabled" else "Autoplay Disabled"
        }

        // Wi-Fi Only
        val toggleWifi = findViewById<CustomToggle>(R.id.toggle_wifi_only)
        val textWifi = findViewById<TextView>(R.id.text_wifi_only)
        toggleWifi.setOnToggleChangedListener { isOn ->
            textWifi.text = if (isOn) "Download only on Wi-Fi" else "Download on Mobile Data Allowed"
        }

        // High Quality Streaming
        val toggleHQ = findViewById<CustomToggle>(R.id.toggle_high_quality)
        val textHQ = findViewById<TextView>(R.id.text_high_quality)
        toggleHQ.setOnToggleChangedListener { isOn ->
            textHQ.text = if (isOn) "High-Quality Streaming Enabled" else "Standard Quality Streaming"
        }

        // Background Playback
        val toggleBG = findViewById<CustomToggle>(R.id.toggle_background_playback)
        val textBG = findViewById<TextView>(R.id.text_background_playback)
        toggleBG.setOnToggleChangedListener { isOn ->
            textBG.text = if (isOn) "Background Playback Enabled" else "Background Playback Disabled"
        }

        // Subtitles
        val toggleSubs = findViewById<CustomToggle>(R.id.toggle_subtitles)
        val textSubs = findViewById<TextView>(R.id.text_subtitles)
        toggleSubs.setOnToggleChangedListener { isOn ->
            textSubs.text = if (isOn) "Subtitles Enabled" else "Subtitles Disabled"
        }

        // Flash
        val toggleFlash = findViewById<CustomToggle>(R.id.toggle_flash)
        val textFlash = findViewById<TextView>(R.id.text_flash)
        toggleFlash.setOnToggleChangedListener { isOn ->
            textFlash.text = if (isOn) "Flash ON" else "Flash OFF"
        }

        // Filters
        val toggleFilters = findViewById<CustomToggle>(R.id.toggle_filters)
        val textFilters = findViewById<TextView>(R.id.text_filters)
        toggleFilters.setOnToggleChangedListener { isOn ->
            textFilters.text = if (isOn) "Filters Enabled" else "Filters Disabled"
        }
    }
}
