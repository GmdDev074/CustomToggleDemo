package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class AppPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_preferences)

        bindToggle(R.id.toggle_notifications, R.id.text_notifications, "Notifications", ToggleType.NOTIFICATIONS, false)
        bindToggle(R.id.toggle_sound, R.id.text_sound, "Sound", ToggleType.SOUND, false)
        bindToggle(R.id.toggle_vibration, R.id.text_vibration, "Vibration", ToggleType.VIBRATION, false)
        bindToggle(R.id.toggle_autoupdate, R.id.text_autoupdate, "Auto-update", ToggleType.AUTO_UPDATE, false)
        //bindToggle(R.id.toggle_autologin, R.id.text_autologin, "Auto Login", ToggleType.SAVE_PASSWORD, false)
        bindToggle(R.id.toggle_biometrics, R.id.text_biometrics, "Biometrics", ToggleType.BIOMETRICS, false)
        bindToggle(R.id.toggle_layout, R.id.text_layout, "Layout Mode", ToggleType.COMPACT_LAYOUT, false)
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

        // Assign the type so the correct drawables are applied
        toggle.toggleType = type

        // Set the initial state
        toggle.setInitialState(initialState)

        // Update text when toggled
        toggle.setOnToggleChangedListener { isOn ->
            val statusText = when (label) {
                "Notifications" -> if (isOn) "Notifications Enabled" else "Notifications Disabled"
                "Sound" -> if (isOn) "Sound ON" else "Sound OFF"
                "Vibration" -> if (isOn) "Vibration Enabled" else "Vibration Disabled"
                "Auto-update" -> if (isOn) "Auto-update Enabled" else "Auto-update Disabled"
                //"Auto Login" -> if (isOn) "Auto Login Enabled" else "Auto Login Disabled"
                "Biometrics" -> if (isOn) "Biometrics Enabled" else "Biometrics Disabled"
                "Layout Mode" -> if (isOn) "Expanded Layout" else "Compact Layout"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // Set initial text
        text.text = when (label) {
            "Notifications" -> if (initialState) "Notifications Enabled" else "Notifications Disabled"
            "Sound" -> if (initialState) "Sound ON" else "Sound OFF"
            "Vibration" -> if (initialState) "Vibration Enabled" else "Vibration Disabled"
            "Auto-update" -> if (initialState) "Auto-update Enabled" else "Auto-update Disabled"
            //"Auto Login" -> if (initialState) "Auto Login Enabled" else "Auto Login Disabled"
            "Biometrics" -> if (initialState) "Biometrics Enabled" else "Biometrics Disabled"
            "Layout Mode" -> if (initialState) "Expanded Layout" else "Compact Layout"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}
