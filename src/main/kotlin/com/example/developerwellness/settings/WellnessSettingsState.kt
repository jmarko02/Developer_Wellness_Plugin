package com.example.developerwellness.settings

import com.example.developerwellness.settings.model.SettingsState
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@Service(Service.Level.APP)
@State(
    name = "DeveloperWellnessSettings",
    storages = [Storage("DeveloperWellnessSettings.xml")]
)
class WellnessSettingsState : PersistentStateComponent<SettingsState> {

    companion object {
        val instance: WellnessSettingsState
            get() = ApplicationManager.getApplication().getService(WellnessSettingsState::class.java)
    }

    private var myState = SettingsState()

    override fun getState(): SettingsState {
        return myState;
    }

    override fun loadState(state: SettingsState) {
        myState = state;
    }

    var breakIntervalMinutes: Int
        get() = myState.breakIntervalMinutes
        set(value) {
            myState.breakIntervalMinutes = value
        }

    var notificationsEnabled: Boolean
        get() = myState.notificationsEnabled
        set(value) {
            myState.notificationsEnabled = value
        }
    var showExerciseSuggestions: Boolean
        get() = myState.showExerciseSuggestions
        set(value) {
            myState.showExerciseSuggestions = value
        }

    var playSound: Boolean
        get() = myState.playSound
        set(value) {
            myState.playSound = value
        }
}