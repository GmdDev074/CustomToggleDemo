package com.example.customtoggle.demo.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.R
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class DeveloperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        // Developer / Advanced Settings Toggles
        setupToggle(
            R.id.toggle_debug, R.id.text_debug,
            "Debug Mode is ON", "Debug Mode is OFF")

        setupToggle(
            R.id.toggle_logs, R.id.text_logs,
            "Logs are Enabled", "Logs are Disabled")

        setupToggle(
            R.id.toggle_mock, R.id.text_mock,
            "Mock Locations are Enabled", "Mock Locations are OFF")

        setupToggle(
            R.id.toggle_bg_tasks, R.id.text_bg_tasks,
            "Background Tasks are Enabled", "Background Tasks are Disabled")

        setupToggle(
            R.id.toggle_battery, R.id.text_battery,
            "Battery Saver is ON", "Battery Saver is OFF")

        setupToggle(
            R.id.toggle_strict, R.id.text_strict,
            "Strict Mode is ON", "Strict Mode is OFF")

        setupToggle(
            R.id.toggle_bounds, R.id.text_bounds,
            "Layout Bounds are Visible", "Layout Bounds are Hidden")

        setupToggle(
            R.id.toggle_awake, R.id.text_awake,
            "Keep Screen Awake is ON", "Keep Screen Awake is OFF")

        setupToggle(
            R.id.toggle_gpu, R.id.text_gpu,
            "GPU Profiling is ON", "GPU Profiling is OFF")
    }

    private fun setupToggle(toggleId: Int, textId: Int, onText: String, offText: String) {
        val toggle = findViewById<CustomToggle>(toggleId)
        val text = findViewById<TextView>(textId)
        toggle.setOnToggleChangedListener { isOn ->
            text.text = if (isOn) onText else offText
        }
    }
}