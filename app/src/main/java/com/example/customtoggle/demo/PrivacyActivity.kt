package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class PrivacyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        // Location Access
        val toggleLocation = findViewById<CustomToggle>(R.id.toggle_location_access)
        val textLocation = findViewById<TextView>(R.id.text_location_access)
        toggleLocation.setOnToggleChangedListener { isOn ->
            textLocation.text = if (isOn) "Location Access Allowed" else "Location Access Denied"
        }

        // Camera / Mic
        val toggleCamMic = findViewById<CustomToggle>(R.id.toggle_camera_mic)
        val textCamMic = findViewById<TextView>(R.id.text_camera_mic)
        toggleCamMic.setOnToggleChangedListener { isOn ->
            textCamMic.text = if (isOn) "Camera & Mic Allowed" else "Camera & Mic Disabled"
        }

        // Online Status
        val toggleStatus = findViewById<CustomToggle>(R.id.toggle_online_status)
        val textStatus = findViewById<TextView>(R.id.text_online_status)
        toggleStatus.setOnToggleChangedListener { isOn ->
            textStatus.text = if (isOn) "Online Status Visible" else "Online Status Hidden"
        }

        // Read Receipts
        val toggleReceipts = findViewById<CustomToggle>(R.id.toggle_read_receipts)
        val textReceipts = findViewById<TextView>(R.id.text_read_receipts)
        toggleReceipts.setOnToggleChangedListener { isOn ->
            textReceipts.text = if (isOn) "Read Receipts Enabled" else "Read Receipts Disabled"
        }

        // 2FA
        val toggle2FA = findViewById<CustomToggle>(R.id.toggle_2fa)
        val text2FA = findViewById<TextView>(R.id.text_2fa)
        toggle2FA.setOnToggleChangedListener { isOn ->
            text2FA.text = if (isOn) "Two-Factor Auth Enabled" else "Two-Factor Auth Disabled"
        }

        // Incognito
        val toggleIncognito = findViewById<CustomToggle>(R.id.toggle_incognito)
        val textIncognito = findViewById<TextView>(R.id.text_incognito)
        toggleIncognito.setOnToggleChangedListener { isOn ->
            textIncognito.text = if (isOn) "Incognito Mode Enabled" else "Incognito Mode Disabled"
        }

        // App Lock
        val toggleAppLock = findViewById<CustomToggle>(R.id.toggle_app_lock)
        val textAppLock = findViewById<TextView>(R.id.text_app_lock)
        toggleAppLock.setOnToggleChangedListener { isOn ->
            textAppLock.text = if (isOn) "App Lock Enabled" else "App Lock Disabled"
        }

        // Typing Indicator
        val toggleTyping = findViewById<CustomToggle>(R.id.toggle_typing_indicator)
        val textTyping = findViewById<TextView>(R.id.text_typing_indicator)
        toggleTyping.setOnToggleChangedListener { isOn ->
            textTyping.text = if (isOn) "Typing Indicator Shown" else "Typing Indicator Hidden"
        }
    }
}
