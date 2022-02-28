package com.tzuzulcode.ahorcado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.tzuzulcode.ahorcado.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding:FragmentResultBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        val view = binding.root

        binding.result.text = ResultFragmentArgs.fromBundle(requireArguments()).result

        binding.newGame.setOnClickListener {
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment)
        }

        return view
    }
}