package com.example.customtoggle.demo.toggle_helper

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.customtoggle.demo.R

class CustomToggle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var track: View
    private var thumb: View
    private var labelOn: TextView
    private var labelOff: TextView

    private var listener: ((Boolean) -> Unit)? = null
    private var isOn: Boolean = false

    var toggleType: ToggleType = ToggleType.NOTIFICATIONS
        set(value) {
            field = value
            applyToggleType()
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_toggle, this, true)
        track = findViewById(R.id.toggle_track)
        thumb = findViewById(R.id.toggle_thumb)
        labelOn = findViewById(R.id.toggle_label_on)
        labelOff = findViewById(R.id.toggle_label_off)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomToggle)
            val typeOrdinal = typedArray.getInt(R.styleable.CustomToggle_toggleType, 0)
            toggleType = ToggleType.values()[typeOrdinal]
            typedArray.recycle()
        }

        setOnClickListener { toggle() }

        applyToggleType()
        updateUI()
    }

    private var trackOnDrawable: Int = R.drawable.bg_track_on
    private var trackOffDrawable: Int = R.drawable.bg_track_off
    private var thumbOnDrawable: Int = R.drawable.bg_thumb_on  // Assume you have a proper on thumb drawable
    private var thumbOffDrawable: Int = R.drawable.bg_thumb_off  // Assume you have a proper off thumb drawable

    fun setOnToggleChangedListener(listener: (Boolean) -> Unit) {
        this.listener = listener
    }

    fun setInitialState(on: Boolean) {
        isOn = on
        updateUI()
    }

    private fun toggle() {
        isOn = !isOn
        updateUI()
        listener?.invoke(isOn)
    }

    private fun updateUI(animate: Boolean = true) {
        // 1. Set track drawable
        track.background = ContextCompat.getDrawable(context, if (isOn) trackOnDrawable else trackOffDrawable)

        // 2. Set thumb drawable immediately
        thumb.background = ContextCompat.getDrawable(context, if (isOn) thumbOnDrawable else thumbOffDrawable)

        // Hide labels
        labelOn.visibility = GONE
        labelOff.visibility = GONE

        // 3. Move thumb
        post {
            val startX = 0f
            val endX = (track.width - thumb.width - (thumb.layoutParams as MarginLayoutParams).marginStart - (thumb.layoutParams as MarginLayoutParams).marginEnd).toFloat()
            val targetX = if (isOn) endX else startX

            if (animate) {
                thumb.animate()
                    .translationX(targetX)
                    .setDuration(200)
                    .withStartAction {
                        // Make sure drawable is applied before animation
                        thumb.background = ContextCompat.getDrawable(context, if (isOn) thumbOnDrawable else thumbOffDrawable)
                    }
                    .start()
            } else {
                thumb.translationX = targetX
            }
        }
    }

    private fun applyToggleType() {
        // Map toggle types to specific track and thumb drawables (fixed placeholders and duplicates)ic_sun
        when (toggleType) {
            // 1. System
            ToggleType.WIFI -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_wifi_on, R.drawable.ic_wifi_off)
            ToggleType.BLUETOOTH -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_bluetooth_on, R.drawable.ic_bluetooth_off)
            ToggleType.DARK_MODE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_sun, R.drawable.ic_moon)
            ToggleType.LOCATION -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_location_on, R.drawable.ic_location_off)
            ToggleType.MOBILE_DATA -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_data_on, R.drawable.ic_data_off)
            ToggleType.AIRPLANE_MODE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_data_on, R.drawable.ic_data_off)  // Assume proper icons
            ToggleType.DO_NOT_DISTURB -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_dnd_on, R.drawable.ic_dnd_off)

            // 2. App Preferences (fixed duplicates)
            ToggleType.NOTIFICATIONS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_bell_on, R.drawable.ic_bell_off)
            ToggleType.SOUND -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_sound_on, R.drawable.ic_sound_off)
            ToggleType.VIBRATION -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_vibrate_on, R.drawable.ic_vibrate_off)
            ToggleType.AUTO_UPDATE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_autoupdate_on, R.drawable.ic_autoupdate_off)
            ToggleType.SAVE_PASSWORD -> setDrawables(
                R.drawable.bg_track_on,
                R.drawable.bg_track_off,
                R.drawable.ic_password_on,
                R.drawable.ic_password_off
            )
            ToggleType.BIOMETRICS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_biometric_on, R.drawable.ic_biometric_off)
            ToggleType.COMPACT_LAYOUT -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off, R.drawable.ic_layout_compact, R.drawable.ic_layout_expanded)

            // 3. Feature Controls
            ToggleType.GPS_TRACKING -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_gps_on, R.drawable.ic_gps_off)
            ToggleType.BACKGROUND_SYNC -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_sync, R.drawable.ic_sync_blocked)
            ToggleType.CLOUD_BACKUP -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_back_up, R.drawable.ic_back_up_blocked)
            ToggleType.ADS_PERSONALIZATION -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_ad, R.drawable.ic_no_block)
            ToggleType.REMEMBER_ME -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_remember, R.drawable.ic_no_remember)
            ToggleType.OFFLINE_MODE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_wifi_on, R.drawable.ic_wifi_off)

            // 4. Privacy & Security
            ToggleType.PRIVACY_LOCATION -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_location_on, R.drawable.ic_location_off
            )

            ToggleType.CAMERA_MIC -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_camera_mic_on, R.drawable.ic_camera_mic_off
            )

            ToggleType.ONLINE_STATUS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_wifi_on, R.drawable.ic_wifi_off
            )

            ToggleType.READ_RECEIPTS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_read_receipt_on, R.drawable.ic_read_receipt_off
            )

            ToggleType.TWO_FACTOR_AUTH -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_security_on, R.drawable.ic_security_off
            )

            ToggleType.INCOGNITO_MODE -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_incognito_on, R.drawable.ic_incognito_off
            )


            // 5. Media/Device Controls
            ToggleType.AUTOPLAY -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_autoplay_on, R.drawable.ic_autoplay_off
            )

            ToggleType.WIFI_ONLY_DOWNLOAD -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_wifi_on, R.drawable.ic_wifi_off
            )

            ToggleType.HIGH_QUALITY_STREAMING -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.BACKGROUND_PLAYBACK -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.SUBTITLES -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_subtitles_on, R.drawable.ic_subtitles_off
            )

            ToggleType.CAMERA_FLASH -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_flash_on, R.drawable.ic_flash_off
            )

            ToggleType.CAMERA_FILTERS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_filter_on, R.drawable.ic_filter_off
            )


            // 6. Smart Home / IoT
            ToggleType.LIGHT -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_light_on, R.drawable.ic_light_off
            )

            ToggleType.FAN -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_fan_on, R.drawable.ic_fan_off
            )

            ToggleType.AC_HEATER -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_ac_heater_on, R.drawable.ic_ac_heater_off
            )

            ToggleType.DOOR_LOCK -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_lock_on, R.drawable.ic_lock_off
            )

            ToggleType.SECURITY_ALARM -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_alarm_on, R.drawable.ic_alarm_off
            )

            ToggleType.SMART_PLUG -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_plug_on, R.drawable.ic_plug_off
            )


            // 7. User Profile / Account
            ToggleType.SHOW_EMAIL -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_email_visible_on, R.drawable.ic_email_visible_off
            )

            ToggleType.PRIVATE_PROFILE -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_lock_on, R.drawable.ic_lock_off
            )

            ToggleType.MESSAGE_NOTIFICATIONS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_alarm_on, R.drawable.ic_alarm_off
            )

            ToggleType.FRIEND_SUGGESTIONS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_friend_on, R.drawable.ic_friend_off
            )

            ToggleType.ACTIVE_STATUS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_active_on, R.drawable.ic_active_off
            )


            // 8. Developer / Advanced
            ToggleType.DEBUG_MODE -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_debug_on, R.drawable.ic_debug_off
            )

            ToggleType.LOGS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.MOCK_LOCATIONS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_gps_on, R.drawable.ic_gps_off
            )

            ToggleType.BACKGROUND_TASKS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.BATTERY_SAVER -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_flash_on, R.drawable.ic_flash_off
            )

            ToggleType.STRICT_MODE -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.ic_lock_on, R.drawable.ic_lock_off
            )

            ToggleType.LAYOUT_BOUNDS -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.KEEP_AWAKE -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )

            ToggleType.GPU_PROFILING -> setDrawables(
                R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_off
            )


            // 9. Commerce / E-Commerce
            ToggleType.ORDER_TRACKING -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.ONE_CLICK_CHECKOUT -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.OFFERS_NOTIFICATIONS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.SAVE_CARD -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.WISHLIST_SYNC -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.PRICE_DROP_ALERTS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)

            // 10. Fun / Creative
            ToggleType.GAME_MODE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.UNIT_SWITCH -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.LANGUAGE_SWITCH -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.THEME_TOGGLE -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_on,
                R.drawable.ic_sun, R.drawable.ic_moon)
            ToggleType.EMOJI_REACTIONS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
            ToggleType.PARENTAL_CONTROLS -> setDrawables(R.drawable.bg_track_on, R.drawable.bg_track_off,
                R.drawable.bg_track_on, R.drawable.bg_track_on)
        }
        updateUI(animate = false)  // Initial update without animation
    }

    private fun setDrawables(trackOn: Int, trackOff: Int, thumbOn: Int, thumbOff: Int) {
        trackOnDrawable = trackOn
        trackOffDrawable = trackOff
        thumbOnDrawable = thumbOn
        thumbOffDrawable = thumbOff
    }
}