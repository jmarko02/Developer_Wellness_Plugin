package com.example.developerwellness.services

import com.example.developerwellness.settings.WellnessSettingsState
import com.example.developerwellness.util.ExerciseSuggestions
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import java.util.*

@Service(Service.Level.APP)
class WellnessTimerService {

    private var timer: Timer? = null
    private var isRunning = false
    private val settings get() = WellnessSettingsState.instance
    private val exerciseSuggestions = ExerciseSuggestions()

    fun startTimer(intervalMinutes: Int = 30) {
        if (isRunning) return

        timer = Timer().apply {
            scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    if (settings.notificationsEnabled) {
                        showBreakNotification()
                    }
                }
            }, intervalMinutes * 60 * 1000L,
                intervalMinutes * 60 * 1000L)
        }
        isRunning = true
    }
    fun stopTimer() {
        timer?.cancel()
        timer = null
        isRunning = false
    }

    private fun showBreakNotification() {
        ApplicationManager.getApplication().invokeLater {
            NotificationGroupManager.getInstance()
                .getNotificationGroup("Developer Wellness")
                .createNotification(
                    TITLE,
                    if (settings.showExerciseSuggestions)
                        getRandomExerciseSuggestion()
                    else
                        SUGGESTION,
                    NotificationType.INFORMATION
                )
                .notify(null)
        }
    }

    private fun getRandomExerciseSuggestion(): String {
        val exercise = exerciseSuggestions.getRandomExercise()
        return "${exercise.name}: ${exercise.description}"
    }

    fun isTimerRunning(): Boolean = isRunning

    companion object{
        fun getInstance(): WellnessTimerService = ApplicationManager.getApplication().getService(WellnessTimerService::class.java)
        private const val TITLE = "Time for a Break!"
        private const val SUGGESTION = "Take a short break to refresh yourself."
    }
}