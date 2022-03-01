package com.tzuzulcode.ahorcado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.tzuzulcode.ahorcado.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel:GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        //:: indica que obtenemos una referencia a la clase y no al objeto
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        updateScreen()


        binding.guessButton.setOnClickListener {
            viewModel.makeGuess(binding.guess.text.toString().uppercase())
            //Vaciamos el EditText
            binding.guess.text = null

            updateScreen()

            if(viewModel.isWon() || viewModel.isLost()){
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.getFinalMessage())

                view.findNavController().navigate(action)
            }

        }



        return view
    }

    fun updateScreen(){
        binding.word.text = viewModel.displaySecretWord
        binding.lives.text = "Tiene ${viewModel.livesLeft} vidas restantes"
        binding.incorrectGuesses.text = "Letras incorrectas: ${viewModel.incorrectGuesses}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}