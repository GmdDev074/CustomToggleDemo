package com.example.customtoggle.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_settings).setOnClickListener { start(SettingsActivity::class.java) }
        findViewById<Button>(R.id.btn_app_prefs).setOnClickListener { start(AppPreferencesActivity::class.java) }
        findViewById<Button>(R.id.btn_features).setOnClickListener { start(FeaturesActivity::class.java) }
        findViewById<Button>(R.id.btn_privacy).setOnClickListener { start(PrivacyActivity::class.java) }
        findViewById<Button>(R.id.btn_media).setOnClickListener { start(MediaActivity::class.java) }
        findViewById<Button>(R.id.btn_smart_home).setOnClickListener { start(SmartHomeActivity::class.java) }
        findViewById<Button>(R.id.btn_profile).setOnClickListener { start(ProfileActivity::class.java) }
        findViewById<Button>(R.id.btn_developer).setOnClickListener { start(DeveloperActivity::class.java) }
        findViewById<Button>(R.id.btn_commerce).setOnClickListener { start(CommerceActivity::class.java) }
        findViewById<Button>(R.id.btn_fun).setOnClickListener { start(FunActivity::class.java) }
    }

    private fun start(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}
