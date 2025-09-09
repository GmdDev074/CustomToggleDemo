package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class MediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        bindToggle(R.id.toggle_autoplay, R.id.text_autoplay, "Autoplay", ToggleType.AUTOPLAY, false)
        bindToggle(R.id.toggle_wifi_only, R.id.text_wifi_only, "Wi-Fi Only", ToggleType.WIFI_ONLY_DOWNLOAD, false)
        bindToggle(R.id.toggle_high_quality, R.id.text_high_quality, "High Quality Streaming", ToggleType.HIGH_QUALITY_STREAMING, false)
        bindToggle(R.id.toggle_background_playback, R.id.text_background_playback, "Background Playback", ToggleType.BACKGROUND_PLAYBACK, false)
        bindToggle(R.id.toggle_subtitles, R.id.text_subtitles, "Subtitles", ToggleType.SUBTITLES, false)
        bindToggle(R.id.toggle_flash, R.id.text_flash, "Flash", ToggleType.CAMERA_FLASH, false)
        bindToggle(R.id.toggle_filters, R.id.text_filters, "Filters", ToggleType.CAMERA_FILTERS, false)
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
                "Autoplay" -> if (isOn) "Autoplay Enabled" else "Autoplay Disabled"
                "Wi-Fi Only" -> if (isOn) "Download only on Wi-Fi" else "Download on Mobile Data Allowed"
                "High Quality Streaming" -> if (isOn) "High-Quality Streaming Enabled" else "Standard Quality Streaming"
                "Background Playback" -> if (isOn) "Background Playback Enabled" else "Background Playback Disabled"
                "Subtitles" -> if (isOn) "Subtitles Enabled" else "Subtitles Disabled"
                "Flash" -> if (isOn) "Flash ON" else "Flash OFF"
                "Filters" -> if (isOn) "Filters Enabled" else "Filters Disabled"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // set initial text
        text.text = when (label) {
            "Autoplay" -> if (initialState) "Autoplay Enabled" else "Autoplay Disabled"
            "Wi-Fi Only" -> if (initialState) "Download only on Wi-Fi" else "Download on Mobile Data Allowed"
            "High Quality Streaming" -> if (initialState) "High-Quality Streaming Enabled" else "Standard Quality Streaming"
            "Background Playback" -> if (initialState) "Background Playback Enabled" else "Background Playback Disabled"
            "Subtitles" -> if (initialState) "Subtitles Enabled" else "Subtitles Disabled"
            "Flash" -> if (initialState) "Flash ON" else "Flash OFF"
            "Filters" -> if (initialState) "Filters Enabled" else "Filters Disabled"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}
