package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Email
        val toggleEmail = findViewById<CustomToggle>(R.id.toggle_email)
        val textEmail = findViewById<TextView>(R.id.text_email)
        toggleEmail.setOnToggleChangedListener { isOn ->
            textEmail.text = if (isOn) "Email is Visible" else "Email is Hidden"
        }

        // Privacy
        val togglePrivacy = findViewById<CustomToggle>(R.id.toggle_privacy)
        val textPrivacy = findViewById<TextView>(R.id.text_privacy)
        togglePrivacy.setOnToggleChangedListener { isOn ->
            textPrivacy.text = if (isOn) "Profile is Private" else "Profile is Public"
        }

        // Notifications
        val toggleNotifications = findViewById<CustomToggle>(R.id.toggle_notifications)
        val textNotifications = findViewById<TextView>(R.id.text_notifications)
        toggleNotifications.setOnToggleChangedListener { isOn ->
            textNotifications.text = if (isOn) "Push Notifications are ON" else "Push Notifications are OFF"
        }

        // Friend Suggestions
        val toggleFriends = findViewById<CustomToggle>(R.id.toggle_friends)
        val textFriends = findViewById<TextView>(R.id.text_friends)
        toggleFriends.setOnToggleChangedListener { isOn ->
            textFriends.text = if (isOn) "Friend Suggestions are Enabled" else "Friend Suggestions are Disabled"
        }

        // Active Status
        val toggleStatus = findViewById<CustomToggle>(R.id.toggle_status)
        val textStatus = findViewById<TextView>(R.id.text_status)
        toggleStatus.setOnToggleChangedListener { isOn ->
            textStatus.text = if (isOn) "Active Status is Visible" else "Active Status is Hidden"
        }
    }
}
