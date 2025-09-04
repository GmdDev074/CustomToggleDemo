package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class SmartHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_home)

        // Light
        val toggleLight = findViewById<CustomToggle>(R.id.toggle_light)
        val textLight = findViewById<TextView>(R.id.text_light)
        toggleLight.setOnToggleChangedListener { isOn ->
            textLight.text = if (isOn) "Light is ON" else "Light is OFF"
        }

        // Fan
        val toggleFan = findViewById<CustomToggle>(R.id.toggle_fan)
        val textFan = findViewById<TextView>(R.id.text_fan)
        toggleFan.setOnToggleChangedListener { isOn ->
            textFan.text = if (isOn) "Fan is ON" else "Fan is OFF"
        }

        // AC / Heater
        val toggleAC = findViewById<CustomToggle>(R.id.toggle_ac)
        val textAC = findViewById<TextView>(R.id.text_ac)
        toggleAC.setOnToggleChangedListener { isOn ->
            textAC.text = if (isOn) "AC/Heater is ON" else "AC/Heater is OFF"
        }

        // Door Lock
        val toggleDoor = findViewById<CustomToggle>(R.id.toggle_door)
        val textDoor = findViewById<TextView>(R.id.text_door)
        toggleDoor.setOnToggleChangedListener { isOn ->
            textDoor.text = if (isOn) "Door is Locked" else "Door is Unlocked"
        }

        // Security Alarm
        val toggleAlarm = findViewById<CustomToggle>(R.id.toggle_alarm)
        val textAlarm = findViewById<TextView>(R.id.text_alarm)
        toggleAlarm.setOnToggleChangedListener { isOn ->
            textAlarm.text = if (isOn) "Security Alarm is ON" else "Security Alarm is OFF"
        }

        // Smart Plug
        val togglePlug = findViewById<CustomToggle>(R.id.toggle_plug)
        val textPlug = findViewById<TextView>(R.id.text_plug)
        togglePlug.setOnToggleChangedListener { isOn ->
            textPlug.text = if (isOn) "Smart Plug is ON" else "Smart Plug is OFF"
        }
    }
}
