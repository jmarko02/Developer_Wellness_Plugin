package com.example.developerwellness.services

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service

@Service(Service.Level.APP)
class WellnessTimerService {

    companion object{
        fun getInstance(): WellnessTimerService = ApplicationManager.getApplication().getService(WellnessTimerService::class.java)
    }
}