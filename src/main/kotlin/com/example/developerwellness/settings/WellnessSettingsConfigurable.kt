package com.example.developerwellness.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JSpinner
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.builder.selected

class WellnessSettingsConfigurable : Configurable {

    private var mainPanel: JPanel? = null
    private var breakIntervalSpinner: JSpinner? = null
    private var notificationEnabledCheckBox: javax.swing.JCheckBox? = null

    private val settings get() = WellnessSettingsState.instance

    override fun createComponent(): JComponent? {
        mainPanel = panel {
            group("Break Timer Settings") {
                row("Break Interval (minutes):") {
                    spinner(IntRange(5, 120), 30)
                        .also { breakIntervalSpinner = it.component }
                }
                row("Enable Notifications:") {
                    checkBox("")
                        .selected(settings.notificationsEnabled)
                        .also { notificationEnabledCheckBox = it.component }
                }
            }

            group("Notification Settings") {
                row("Show Exercise Suggestions:") {
                    checkBox("")
                        .selected(settings.showExerciseSuggestions)
                }
                row("Play Sound:") {
                    checkBox("")
                        .selected(settings.playSound)
                }
            }
        }
        return mainPanel
    }

    override fun isModified(): Boolean {
        return settings.breakIntervalMinutes != (breakIntervalSpinner?.value as? Int ?: 30) ||
                settings.notificationsEnabled != (notificationEnabledCheckBox?.isSelected ?: true)
    }

    override fun apply() {
        settings.breakIntervalMinutes = breakIntervalSpinner?.value as? Int ?: 30
        settings.notificationsEnabled = notificationEnabledCheckBox?.isSelected ?: true
    }

    override fun getDisplayName(): String = NAME

    override fun getPreferredFocusedComponent(): JComponent? = breakIntervalSpinner

    companion object {
        private const val NAME = "Developer Wellness"
    }
}