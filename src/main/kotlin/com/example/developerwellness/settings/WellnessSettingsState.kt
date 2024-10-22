package com.example.developerwellness.settings

import com.example.developerwellness.settings.model.SettingsState
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
    override fun getState(): SettingsState? {
        TODO("Not yet implemented")
    }

    override fun loadState(state: SettingsState) {
        TODO("Not yet implemented")
    }
}