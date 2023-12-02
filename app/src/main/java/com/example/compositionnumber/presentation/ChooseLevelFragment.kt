package com.example.compositionnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.compositionnumber.R
import com.example.compositionnumber.databinding.FragmentChooseLevelBinding
import com.example.compositionnumber.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonLevelTest.setOnClickListener { launchGame(Level.TEST) }
            buttonLevelEasy.setOnClickListener { launchGame(Level.EASY) }
            buttonLevelNormal.setOnClickListener { launchGame(Level.NORMAL) }
            buttonLevelHard.setOnClickListener { launchGame(Level.HARD) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGame(level: Level) {
        val args = Bundle().apply {
            putParcelable(GameFragment.KEY_GAME_LEVEL, level)
        }
        findNavController().navigate(
            R.id.action_chooseLevelFragment_to_gameFragment,
            args,
            navOptions {
                anim {
                    enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                    popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                    popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                    exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                }
            }
        )
    }

}