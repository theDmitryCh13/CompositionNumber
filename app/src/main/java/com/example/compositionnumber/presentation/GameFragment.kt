package com.example.compositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.compositionnumber.R
import com.example.compositionnumber.databinding.FragmentGameBinding
import com.example.compositionnumber.databinding.FragmentWelcomeBinding
import com.example.compositionnumber.domain.entity.Level

class GameFragment : Fragment() {

    lateinit var level: Level

    private var _binding : FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseLevel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseLevel() {
        level = requireArguments().getSerializable(KEY_GAME_LEVEL) as Level
    }

    companion object {

        private const val KEY_GAME_LEVEL = "level"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_GAME_LEVEL,level)
                }
            }
        }
    }
}