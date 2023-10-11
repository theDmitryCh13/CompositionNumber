package com.example.compositionnumber.domain.repository

import com.example.compositionnumber.domain.entity.GameSettings
import com.example.compositionnumber.domain.entity.Level
import com.example.compositionnumber.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSum: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings

}