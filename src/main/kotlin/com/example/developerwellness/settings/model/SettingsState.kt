package com.example.developerwellness.settings.model

data class SettingsState(
    var breakIntervalMinutes: Int = 30,        // Default break interval
    var notificationsEnabled: Boolean = true,   // Default notifications enabled
    var showExerciseSuggestions: Boolean = true,// Default show exercise suggestions
    var playSound: Boolean = true               // Default play sound enabled
)