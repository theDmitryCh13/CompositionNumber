package com.example.compositionnumber.domain.useCases

import com.example.compositionnumber.domain.entity.Question
import com.example.compositionnumber.domain.repository.GameRepository

class GenerationQuestionUseCase (
    private val repository: GameRepository
) {

    operator fun invoke(maxSum: Int): Question {
        return repository.generateQuestion(maxSum, COUNT_OF_OPTIONS)
    }

    private companion object {

        private const val COUNT_OF_OPTIONS = 6
    }
}