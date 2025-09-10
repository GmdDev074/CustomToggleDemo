package com.example.customtoggle.demo.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.R
import com.example.customtoggle.demo.toggle_helper.CustomToggle
import com.example.customtoggle.demo.toggle_helper.ToggleType

class SmartHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_home)

        bindToggle(R.id.toggle_light, R.id.text_light, "Light", ToggleType.LIGHT, false)
        bindToggle(R.id.toggle_fan, R.id.text_fan, "Fan", ToggleType.FAN, false)
        bindToggle(R.id.toggle_ac, R.id.text_ac, "AC/Heater", ToggleType.AC_HEATER, false)
        bindToggle(R.id.toggle_door, R.id.text_door, "Door Lock", ToggleType.DOOR_LOCK, false)
        bindToggle(R.id.toggle_alarm, R.id.text_alarm, "Security Alarm", ToggleType.SECURITY_ALARM, false)
        bindToggle(R.id.toggle_plug, R.id.text_plug, "Smart Plug", ToggleType.SMART_PLUG, false)
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
                "Light" -> if (isOn) "Light is ON" else "Light is OFF"
                "Fan" -> if (isOn) "Fan is ON" else "Fan is OFF"
                "AC/Heater" -> if (isOn) "AC/Heater is ON" else "AC/Heater is OFF"
                "Door Lock" -> if (isOn) "Door is Locked" else "Door is Unlocked"
                "Security Alarm" -> if (isOn) "Security Alarm is ON" else "Security Alarm is OFF"
                "Smart Plug" -> if (isOn) "Smart Plug is ON" else "Smart Plug is OFF"
                else -> "$label is ${if (isOn) "ON" else "OFF"}"
            }
            text.text = statusText
        }

        // set initial text
        text.text = when (label) {
            "Light" -> if (initialState) "Light is ON" else "Light is OFF"
            "Fan" -> if (initialState) "Fan is ON" else "Fan is OFF"
            "AC/Heater" -> if (initialState) "AC/Heater is ON" else "AC/Heater is OFF"
            "Door Lock" -> if (initialState) "Door is Locked" else "Door is Unlocked"
            "Security Alarm" -> if (initialState) "Security Alarm is ON" else "Security Alarm is OFF"
            "Smart Plug" -> if (initialState) "Smart Plug is ON" else "Smart Plug is OFF"
            else -> "$label is ${if (initialState) "ON" else "OFF"}"
        }
    }
}