package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        bindToggle(R.id.toggle_email, R.id.text_email, "Email", ToggleType.SHOW_EMAIL, false)
        bindToggle(R.id.toggle_privacy, R.id.text_privacy, "Privacy", ToggleType.PRIVATE_PROFILE, false)
        bindToggle(R.id.toggle_notifications, R.id.text_notifications, "Notifications", ToggleType.MESSAGE_NOTIFICATIONS, false)
        bindToggle(R.id.toggle_friends, R.id.text_friends, "Friend Suggestions", ToggleType.FRIEND_SUGGESTIONS, false)
        bindToggle(R.id.toggle_status, R.id.text_status, "Active Status", ToggleType.ACTIVE_STATUS, false)
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

        toggle.toggleType = type
        toggle.setInitialState(initialState)

        toggle.setOnToggleChangedListener { isOn ->
            val statusText = when (label) {
                "Email" -> if (isOn) "Email is Visible" else "Email is Hidden"
                "Privacy" -> if (isOn) "Profile is Private" else "Profile is Public"
                "Notifications" -> if (isOn) "Push Notifications are ON" else "Push Notifications are OFF"
                "Friend Suggestions" -> if (isOn) "Friend Suggestions are Enabled" else "Friend Suggestions are Disabled"
                "Active Status" -> if (isOn) "Active Status is Visible" else "Active Status is Hidden"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // initial UI state
        text.text = when (label) {
            "Email" -> if (initialState) "Email is Visible" else "Email is Hidden"
            "Privacy" -> if (initialState) "Profile is Private" else "Profile is Public"
            "Notifications" -> if (initialState) "Push Notifications are ON" else "Push Notifications are OFF"
            "Friend Suggestions" -> if (initialState) "Friend Suggestions are Enabled" else "Friend Suggestions are Disabled"
            "Active Status" -> if (initialState) "Active Status is Visible" else "Active Status is Hidden"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}
