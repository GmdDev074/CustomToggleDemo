package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Wi-Fi toggle
        bindToggle(R.id.toggle_wifi, R.id.text_wifi, "Wi-Fi", ToggleType.WIFI, false)

        // Bluetooth toggle
        bindToggle(R.id.toggle_bt, R.id.text_bt, "Bluetooth", ToggleType.BLUETOOTH, false)

        // Dark Mode toggle
        bindToggle(R.id.toggle_darkmode, R.id.text_darkmode, "Dark Mode", ToggleType.THEME_TOGGLE, false)

        // Location toggle
        bindToggle(R.id.toggle_location, R.id.text_location, "Location", ToggleType.LOCATION, false)

        // Mobile Data toggle
        bindToggle(R.id.toggle_data, R.id.text_data, "Mobile Data", ToggleType.MOBILE_DATA, false)

        // Airplane Mode toggle
        bindToggle(R.id.toggle_airplane, R.id.text_airplane, "Airplane Mode", ToggleType.AIRPLANE_MODE, false)

        // Do Not Disturb toggle
        bindToggle(R.id.toggle_dnd, R.id.text_dnd, "Do Not Disturb", ToggleType.DO_NOT_DISTURB, false)
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

        // Set toggle type (so it uses correct thumb drawable)
        toggle.toggleType = type

        // Set initial state
        toggle.setInitialState(initialState)

        // Listener to update text
        toggle.setOnToggleChangedListener { isOn ->
            text.text = "$label is ${if (isOn) "ON" else "OFF"}"
        }

        // Set initial label text
        text.text = "$label is ${if (initialState) "ON" else "OFF"}"
    }
}
