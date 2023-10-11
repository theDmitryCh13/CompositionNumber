package com.example.compositionnumber.domain.useCases

import com.example.compositionnumber.domain.entity.GameSettings
import com.example.compositionnumber.domain.entity.Level
import com.example.compositionnumber.domain.repository.GameRepository

class GetGameSettingsUseCase (
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}