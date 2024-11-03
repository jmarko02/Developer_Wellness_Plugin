package com.example.developerwellness.actions

import com.example.developerwellness.services.WellnessTimerService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class StartTimerAction : AnAction(), DumbAware {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val timerService = WellnessTimerService.getInstance()

        if (!timerService.isTimerRunning()) {
            timerService.startTimer(1)
            showNotification(project)
        }
    }

    private fun showNotification(project:Project) {
        Messages.showInfoMessage(project, MESSAGE, TITLE)
    }

    companion object{
        private const val MESSAGE = "Break reminders are now active"
        private const val TITLE = "Wellness Timer Started"
    }
}