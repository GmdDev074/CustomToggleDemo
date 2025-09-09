package com.example.customtoggle.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customtoggle.demo.toggle_helper.CustomToggle

class CommerceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commerce)

        // Core E-Commerce Toggles
        setupToggle(R.id.toggle_order_tracking, R.id.text_order_tracking,
            "Order Tracking is Enabled", "Order Tracking is Disabled")

        setupToggle(R.id.toggle_checkout, R.id.text_checkout,
            "One-Click Checkout is ON", "One-Click Checkout is OFF")

        setupToggle(R.id.toggle_offers, R.id.text_offers,
            "Offers Notifications are ON", "Offers Notifications are OFF")

        setupToggle(R.id.toggle_card, R.id.text_card,
            "Save Card is Enabled", "Save Card is Disabled")

        // Extended E-Commerce Toggles
        setupToggle(R.id.toggle_wishlist, R.id.text_wishlist,
            "Wishlist Sync is ON", "Wishlist Sync is OFF")

        setupToggle(R.id.toggle_price_alerts, R.id.text_price_alerts,
            "Price Drop Alerts are ON", "Price Drop Alerts are OFF")
    }

    private fun setupToggle(toggleId: Int, textId: Int, onText: String, offText: String) {
        val toggle = findViewById<CustomToggle>(toggleId)
        val text = findViewById<TextView>(textId)
        toggle.setOnToggleChangedListener { isOn ->
            text.text = if (isOn) onText else offText
        }
    }
}
