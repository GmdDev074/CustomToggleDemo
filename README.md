# CustomToggle Library 🎛️

![License](https://img.shields.io/github/license/GmdDev074/CustomToggleDemo)

[![](https://jitpack.io/v/GmdDev074/CustomToggleDemo.svg)](https://jitpack.io/#GmdDev074/CustomToggleDemo)

![GitHub stars](https://img.shields.io/github/stars/GmdDev074/CustomToggleDemo?style=social)
![GitHub forks](https://img.shields.io/github/forks/GmdDev074/CustomToggleDemo?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/GmdDev074/CustomToggleDemo?style=social)

![License](https://img.shields.io/github/license/GmdDev074/CustomToggleDemo)
![GitHub release](https://img.shields.io/github/v/release/GmdDev074/CustomToggleDemo)
![Release Date](https://img.shields.io/github/release-date/GmdDev074/CustomToggleDemo)
![Issues](https://img.shields.io/github/issues/GmdDev074/CustomToggleDemo)
![Pull Requests](https://img.shields.io/github/issues-pr/GmdDev074/CustomToggleDemo)
![Top Language](https://img.shields.io/github/languages/top/GmdDev074/CustomToggleDemo)
![Contributors](https://img.shields.io/github/contributors/GmdDev074/CustomToggleDemo)

![Last Commit](https://img.shields.io/github/last-commit/GmdDev074/CustomToggleDemo)
![GitHub all releases](https://img.shields.io/github/downloads/GmdDev074/CustomToggleDemo/total)
![Commit Activity](https://img.shields.io/github/commit-activity/m/GmdDev074/CustomToggleDemo)
![Maintenance](https://img.shields.io/maintenance/yes/2025)
![Dependabot Status](https://img.shields.io/badge/dependabot-enabled-brightgreen?logo=dependabot)

![Min SDK](https://img.shields.io/badge/minSdk-21%2B-blue)
![API](https://img.shields.io/badge/API-21%2B-green.svg?style=flat)
![Lint](https://img.shields.io/badge/lint-passing-brightgreen)
![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)

---

## Contributors

[![Contributors](https://contrib.rocks/image?repo=GmdDev074/CustomToggleDemo)](https://github.com/GmdDev074/CustomToggleDemo/graphs/contributors)

---

## 📖 Overview

**CustomToggle** is a simple yet powerful Android library for adding **custom toggle switches** to your apps.  
It is designed to replace the boring default switches with a **modern, customizable toggle button** that can adapt to your brand and UI.  

---

## ✨ Features

- **Custom ON/OFF text**  
- **Customizable colors and styles**  
- **Lightweight** – minimal code, no heavy dependencies  
- **Easy integration** – works with just a few lines of code  
- **Supports click listeners** to detect state change  

---

## 📸 Screenshots  

<p float="left">
  <img src="https://github.com/user-attachments/assets/fa2a3202-3314-43f5-a714-bba3e9b729ca" width="180" />
  <img src="https://github.com/user-attachments/assets/76cd0279-d615-4b81-b723-3b58e34f83f2" width="180" />
  <img src="https://github.com/user-attachments/assets/025512c7-c70a-40ec-b52c-04986ac766e2" width="180" />
  <img src="https://github.com/user-attachments/assets/67bac086-ec0d-4da5-8a9f-6c2883a5bc37" width="180" />
  <img src="https://github.com/user-attachments/assets/5f8fa8d2-8a96-4d3f-b0db-f32a60d87bb1" width="180" />
  <img src="https://github.com/user-attachments/assets/332ecb6f-2d72-4961-b8eb-2861ebceacba" width="180" />
  <img src="https://github.com/user-attachments/assets/92c9c391-d35e-42d1-b94a-13caca8e8e27" width="180" />
  <img src="https://github.com/user-attachments/assets/08a58edc-b8c8-4787-93a4-1f31bdfecaa5" width="180" />
</p>

---

## ⚙️ Installation

### Step 1: Add JitPack

Add this to your **root `settings.gradle`** (or `build.gradle` for Groovy):

```
kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2: Add Depedency

Add dependency in your **app-level** `build.gradle`:

```
    implementation("com.github.GmdDev074:CustomToggleDemo:v1.0.0")
```

🔖 Replace v1.0.0 with the latest release


### Step 3: 🛠️ Usage

```
<com.gmd.customtoggle.CustomToggleView
    android:id="@+id/customToggle"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:toggleOnText="ON"
    app:toggleOffText="OFF"
    app:toggleDefaultState="off"
    app:toggleType="SOUND"/>
```

### Step 4: Toggle Types

```

enum class ToggleType {
    // 1. System / App Settings
    WIFI, BLUETOOTH, DARK_MODE, LOCATION, MOBILE_DATA, AIRPLANE_MODE, DO_NOT_DISTURB,

    // 2. App Preferences
    NOTIFICATIONS, SOUND, VIBRATION, AUTO_UPDATE, SAVE_PASSWORD, BIOMETRICS, COMPACT_LAYOUT,

    // 3. Feature Controls
    GPS_TRACKING, BACKGROUND_SYNC, CLOUD_BACKUP, ADS_PERSONALIZATION, REMEMBER_ME, OFFLINE_MODE,

    // 4. Privacy & Security
    PRIVACY_LOCATION, CAMERA_MIC, ONLINE_STATUS, READ_RECEIPTS, TWO_FACTOR_AUTH, INCOGNITO_MODE,

    // 5. Media / Device Controls
    AUTOPLAY, WIFI_ONLY_DOWNLOAD, HIGH_QUALITY_STREAMING, BACKGROUND_PLAYBACK, SUBTITLES,
    CAMERA_FLASH, CAMERA_FILTERS,

    // 6. Smart Home / IoT
    LIGHT, FAN, AC_HEATER, DOOR_LOCK, SECURITY_ALARM, SMART_PLUG,

    // 7. User Profile / Account
    SHOW_EMAIL, PRIVATE_PROFILE, MESSAGE_NOTIFICATIONS, FRIEND_SUGGESTIONS, ACTIVE_STATUS,

    // 8. Developer / Advanced Settings
    DEBUG_MODE,
    LOGS,
    MOCK_LOCATIONS,
    BACKGROUND_TASKS,
    BATTERY_SAVER,
    STRICT_MODE,
    LAYOUT_BOUNDS,
    KEEP_AWAKE,
    GPU_PROFILING,

    // 9. Commerce / E-Commerce Apps
    ORDER_TRACKING, ONE_CLICK_CHECKOUT, OFFERS_NOTIFICATIONS, SAVE_CARD, WISHLIST_SYNC, PRICE_DROP_ALERTS,

    // 10. Fun / Creative Uses
    GAME_MODE, UNIT_SWITCH, LANGUAGE_SWITCH, THEME_TOGGLE, EMOJI_REACTIONS, PARENTAL_CONTROLS
}

```

### Step 5: Attributes for the XML support to change the toggle

```

<declare-styleable name="CustomToggle">
        <attr name="toggleType" format="enum">
            <!-- 1. System / App Settings -->
            <enum name="WIFI" value="0"/>
            <enum name="BLUETOOTH" value="1"/>
            <enum name="DARK_MODE" value="2"/>
            <enum name="LOCATION" value="3"/>
            <enum name="MOBILE_DATA" value="4"/>
            <enum name="AIRPLANE_MODE" value="5"/>
            <enum name="DO_NOT_DISTURB" value="6"/>

            <!-- 2. App Preferences -->
            <enum name="NOTIFICATIONS" value="7"/>
            <enum name="SOUND" value="8"/>
            <enum name="VIBRATION" value="9"/>
            <enum name="AUTO_UPDATE" value="10"/>
            <enum name="SAVE_PASSWORD" value="11"/>
            <enum name="BIOMETRICS" value="12"/>
            <enum name="COMPACT_LAYOUT" value="13"/>

            <!-- 3. Feature Controls -->
            <enum name="GPS_TRACKING" value="14"/>
            <enum name="BACKGROUND_SYNC" value="15"/>
            <enum name="CLOUD_BACKUP" value="16"/>
            <enum name="ADS_PERSONALIZATION" value="17"/>
            <enum name="REMEMBER_ME" value="18"/>
            <enum name="OFFLINE_MODE" value="19"/>

            <!-- 4. Privacy & Security -->
            <enum name="PRIVACY_LOCATION" value="20"/>
            <enum name="CAMERA_MIC" value="21"/>
            <enum name="ONLINE_STATUS" value="22"/>
            <enum name="READ_RECEIPTS" value="23"/>
            <enum name="TWO_FACTOR_AUTH" value="24"/>
            <enum name="INCOGNITO_MODE" value="25"/>

            <!-- 5. Media / Device Controls -->
            <enum name="AUTOPLAY" value="26"/>
            <enum name="WIFI_ONLY_DOWNLOAD" value="27"/>
            <enum name="HIGH_QUALITY_STREAMING" value="28"/>
            <enum name="BACKGROUND_PLAYBACK" value="29"/>
            <enum name="SUBTITLES" value="30"/>
            <enum name="CAMERA_FLASH" value="31"/>
            <enum name="CAMERA_FILTERS" value="32"/>

            <!-- 6. Smart Home / IoT -->
            <enum name="LIGHT" value="33"/>
            <enum name="FAN" value="34"/>
            <enum name="AC_HEATER" value="35"/>
            <enum name="DOOR_LOCK" value="36"/>
            <enum name="SECURITY_ALARM" value="37"/>
            <enum name="SMART_PLUG" value="38"/>

            <!-- 7. User Profile / Account -->
            <enum name="SHOW_EMAIL" value="39"/>
            <enum name="PRIVATE_PROFILE" value="40"/>
            <enum name="MESSAGE_NOTIFICATIONS" value="41"/>
            <enum name="FRIEND_SUGGESTIONS" value="42"/>
            <enum name="ACTIVE_STATUS" value="43"/>

            <!-- 8. Developer / Advanced Settings -->
            <enum name="DEBUG_MODE" value="44"/>
            <enum name="LOGS" value="45"/>
            <enum name="MOCK_LOCATIONS" value="46"/>
            <enum name="BACKGROUND_TASKS" value="47"/>
            <enum name="BATTERY_SAVER" value="48"/>
            <enum name="STRICT_MODE" value="49"/>
            <enum name="LAYOUT_BOUNDS" value="50"/>
            <enum name="KEEP_AWAKE" value="51"/>
            <enum name="GPU_PROFILING" value="52"/>

            <!-- 9. Commerce / E-Commerce Apps -->
            <enum name="ORDER_TRACKING" value="53"/>
            <enum name="ONE_CLICK_CHECKOUT" value="54"/>
            <enum name="OFFERS_NOTIFICATIONS" value="55"/>
            <enum name="SAVE_CARD" value="56"/>
            <enum name="WISHLIST_SYNC" value="57"/>        <!-- ✅ -->
            <enum name="PRICE_DROP_ALERTS" value="58"/>    <!-- ✅ -->

            <!-- 10. Fun / Creative Uses -->
            <enum name="GAME_MODE" value="59"/>
            <enum name="UNIT_SWITCH" value="60"/>
            <enum name="LANGUAGE_SWITCH" value="61"/>
            <enum name="THEME_TOGGLE" value="62"/>
            <enum name="EMOJI_REACTIONS" value="63"/>
            <enum name="PARENTAL_CONTROLS" value="64"/>
        </attr>
    </declare-styleable>

```

### Step 6: Kotlin Example

```

val toggle = findViewById<CustomToggleView>(R.id.customToggle)

toggle.setOnToggleChangedListener { isOn ->
    if (isOn) {
        // Do something when toggled ON
    } else {
        // Do something when toggled OFF
    }
}

```


## 🤝 Collaboration

We’d love your support to make **CustomToggle** even better! 🚀  
Whether it’s **reporting bugs, suggesting new features, improving docs, or submitting pull requests** – every contribution counts.  

If you’re interested in collaborating:  
- Fork the repo 🍴  
- Create your feature branch 🌱  
- Submit a PR ✅  
- Join the discussions 💬  

Your ideas and improvements are always welcome!  

---

## ⭐ Support

If you find **CustomToggle** useful, please consider **giving it a star ⭐ on GitHub**.  
It only takes a second, but it really motivates us to keep improving this project!  

[![GitHub Stars](https://img.shields.io/github/stars/GmdDev074/CustomToggleDemo?style=social)](https://github.com/GmdDev074/CustomToggleDemo/stargazers)


## 📜 License

This project is licensed under the [Apache License 2.0](LICENSE).  
See the [NOTICE](NOTICE) file for copyright details.
