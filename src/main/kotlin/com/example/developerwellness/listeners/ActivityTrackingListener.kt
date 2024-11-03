package com.example.developerwellness.listeners

import com.example.developerwellness.services.WellnessTimerService
import com.intellij.openapi.components.Service
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

@Service(Service.Level.PROJECT)
class ActivityTrackingListener(private val project: Project): FileEditorManagerListener {

    private var lastActivityTime: Long = System.currentTimeMillis()
    private val timerService = WellnessTimerService.getInstance()

    init {
        project.messageBus.connect().subscribe(
            FileEditorManagerListener.FILE_EDITOR_MANAGER,
            this
        )
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        updateActivity()
    }

    private fun updateActivity() {
        lastActivityTime = System.currentTimeMillis()

        if (!timerService.isTimerRunning()) {
            timerService.startTimer()
            Messages.showInfoMessage(
                project,
                "Break reminders are now active due to detected activity",
                "Wellness Timer Started Automatically"
            )
        }
    }
}