package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class FunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun)

        setupToggle(R.id.toggle_game_mode, R.id.text_game_mode, "Game Mode is ON", "Game Mode is OFF")

        // Units toggle (Km/°C <-> Miles/°F)
        val toggleUnits = findViewById<CustomToggle>(R.id.toggle_units)
        val textUnits = findViewById<TextView>(R.id.text_units)
        toggleUnits.setOnToggleChangedListener { isOn ->
            textUnits.text = if (isOn) "Units: Miles / °F" else "Units: Km / °C"
        }

        // Language toggle (EN <-> UR)
        val toggleLang = findViewById<CustomToggle>(R.id.toggle_language)
        val textLang = findViewById<TextView>(R.id.text_language)
        toggleLang.setOnToggleChangedListener { isOn ->
            textLang.text = if (isOn) "Language: Urdu" else "Language: English"
        }

        // Theme toggle (Light <-> Dark/AMOLED)
        val toggleTheme = findViewById<CustomToggle>(R.id.toggle_theme)
        val textTheme = findViewById<TextView>(R.id.text_theme)
        toggleTheme.setOnToggleChangedListener { isOn ->
            textTheme.text = if (isOn) "Theme: Dark / AMOLED" else "Theme: Light"
        }

        setupToggle(R.id.toggle_emoji, R.id.text_emoji, "Emoji Reactions Enabled", "Emoji Reactions Disabled")
        setupToggle(R.id.toggle_parental, R.id.text_parental, "Parental Controls Enabled", "Parental Controls Disabled")
    }

    private fun setupToggle(toggleId: Int, textId: Int, onText: String, offText: String) {
        val toggle = findViewById<CustomToggle>(toggleId)
        val text = findViewById<TextView>(textId)
        toggle.setOnToggleChangedListener { isOn ->
            text.text = if (isOn) onText else offText
        }
    }
}
