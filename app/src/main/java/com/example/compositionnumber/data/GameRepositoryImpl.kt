package com.example.compositionnumber.data

import com.example.compositionnumber.domain.entity.GameSettings
import com.example.compositionnumber.domain.entity.Level
import com.example.compositionnumber.domain.entity.Question
import com.example.compositionnumber.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository{

    private const val MIN_VALUE_SUM = 2
    private const val MIN_VALUE_VISIBLE_NUMBER = 1

    override fun generateQuestion(maxValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_VALUE_SUM,maxValue + 1)
        val visibleNumber = Random.nextInt(MIN_VALUE_VISIBLE_NUMBER, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_VALUE_VISIBLE_NUMBER)
        val to = min(maxValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from,to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> { GameSettings(
                10,
                3,
                50,
                8
            )
            }
            Level.EASY -> { GameSettings(
                10,
                10,
                70,
                60
            )
            }
            Level.NORMAL -> { GameSettings(
                20,
                20,
                80,
                40
            )
            }
            Level.HARD -> { GameSettings(
                30,
                30,
                90,
                40
            )
            }
        }
    }
}