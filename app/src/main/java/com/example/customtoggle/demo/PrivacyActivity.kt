package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class PrivacyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        bindToggle(R.id.toggle_location_access, R.id.text_location_access, "Location Access", ToggleType.PRIVACY_LOCATION, false)
        bindToggle(R.id.toggle_camera_mic, R.id.text_camera_mic, "Camera & Mic", ToggleType.CAMERA_MIC, false)
        bindToggle(R.id.toggle_online_status, R.id.text_online_status, "Online Status", ToggleType.ONLINE_STATUS, false)
        bindToggle(R.id.toggle_read_receipts, R.id.text_read_receipts, "Read Receipts", ToggleType.READ_RECEIPTS, false)
        bindToggle(R.id.toggle_2fa, R.id.text_2fa, "Two-Factor Auth", ToggleType.TWO_FACTOR_AUTH, false)
        bindToggle(R.id.toggle_incognito, R.id.text_incognito, "Incognito Mode", ToggleType.INCOGNITO_MODE, false)
        bindToggle(R.id.toggle_app_lock, R.id.text_app_lock, "App Lock", ToggleType.BIOMETRICS, false)
        bindToggle(R.id.toggle_typing_indicator, R.id.text_typing_indicator, "Typing Indicator", ToggleType.OFFLINE_MODE, false)
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

        // set toggle type
        toggle.toggleType = type

        // set initial state
        toggle.setInitialState(initialState)

        // update text when toggled
        toggle.setOnToggleChangedListener { isOn ->
            val statusText = when (label) {
                "Location Access" -> if (isOn) "Location Access Allowed" else "Location Access Denied"
                "Camera & Mic" -> if (isOn) "Camera & Mic Allowed" else "Camera & Mic Disabled"
                "Online Status" -> if (isOn) "Online Status Visible" else "Online Status Hidden"
                "Read Receipts" -> if (isOn) "Read Receipts Enabled" else "Read Receipts Disabled"
                "Two-Factor Auth" -> if (isOn) "Two-Factor Auth Enabled" else "Two-Factor Auth Disabled"
                "Incognito Mode" -> if (isOn) "Incognito Mode Enabled" else "Incognito Mode Disabled"
                "App Lock" -> if (isOn) "App Lock Enabled" else "App Lock Disabled"
                "Typing Indicator" -> if (isOn) "Typing Indicator Shown" else "Typing Indicator Hidden"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // set initial text
        text.text = when (label) {
            "Location Access" -> if (initialState) "Location Access Allowed" else "Location Access Denied"
            "Camera & Mic" -> if (initialState) "Camera & Mic Allowed" else "Camera & Mic Disabled"
            "Online Status" -> if (initialState) "Online Status Visible" else "Online Status Hidden"
            "Read Receipts" -> if (initialState) "Read Receipts Enabled" else "Read Receipts Disabled"
            "Two-Factor Auth" -> if (initialState) "Two-Factor Auth Enabled" else "Two-Factor Auth Disabled"
            "Incognito Mode" -> if (initialState) "Incognito Mode Enabled" else "Incognito Mode Disabled"
            "App Lock" -> if (initialState) "App Lock Enabled" else "App Lock Disabled"
            "Typing Indicator" -> if (initialState) "Typing Indicator Shown" else "Typing Indicator Hidden"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}
