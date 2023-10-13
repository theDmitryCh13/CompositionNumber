package com.example.compositionnumber.data

import com.example.compositionnumber.domain.entity.GameSettings
import com.example.compositionnumber.domain.entity.Level
import com.example.compositionnumber.domain.entity.Question
import com.example.compositionnumber.domain.repository.GameRepository

object GameRepositoryImpl : GameRepository {
    override fun generateQuestion(maxSum: Int, countOfOptions: Int): Question {
        TODO("Not yet implemented")
    }

    override fun getGameSettings(level: Level): GameSettings {
        TODO("Not yet implemented")
    }
}