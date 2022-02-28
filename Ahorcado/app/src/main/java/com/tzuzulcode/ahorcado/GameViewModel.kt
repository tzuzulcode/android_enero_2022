package com.tzuzulcode.ahorcado

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val words = listOf("Android","Binding","Fragment","Layout","Activity")

    var secretWord = words.random().uppercase()
    var livesLeft = 5
    var incorrectGuesses = ""
    var correctGuesses = ""
    var displaySecretWord = ""

    init{
        displaySecretWord = getSecretWordDisplay()
    }

    fun checkLetter(str:String) = when(correctGuesses.contains(str)){
        true->str
        false->"_"
    }

    fun getSecretWordDisplay():String{
        var display = ""

        secretWord.forEach {
            display+=checkLetter(it.toString())
        }

        return display
    }

    fun makeGuess(guess:String){
        if(guess.length==1){
            if(secretWord.contains(guess)){
                correctGuesses+=guess
                displaySecretWord = getSecretWordDisplay()
            }else{
                incorrectGuesses += "$guess "
                livesLeft--
            }
        }
    }



    fun isWon() = secretWord.equals(displaySecretWord,true)

    fun isLost() = livesLeft<=0

    fun getFinalMessage():String{
        var message = ""

        if(isWon()){
            message="Has ganado!"
        }else{
            message="Has perdido!"
        }

        message+=" La palabra era: $secretWord"

        return message
    }



}