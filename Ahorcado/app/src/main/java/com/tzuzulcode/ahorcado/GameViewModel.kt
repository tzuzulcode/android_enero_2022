package com.tzuzulcode.ahorcado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private val words = listOf("Android","Binding","Fragment","Layout","Activity")

    private val secretWord = words.random().uppercase()
    var correctGuesses = ""

    //Definiendo propiedades de Mutable live data como private:
    private val _livesLeft = MutableLiveData<Int>(5)
    val livesLeft:LiveData<Int>
        get() = _livesLeft


    private val _incorrectGuesses = MutableLiveData("")
    val incorrectGuesses:LiveData<String>
        get() = _incorrectGuesses

    private val _displaySecretWord = MutableLiveData("")
    val displaySecretWord:LiveData<String>
        get() = _displaySecretWord

    private val _gameOver = MutableLiveData(false)
    val gameOver:LiveData<Boolean>
        get() = _gameOver

    init{
        _displaySecretWord.value = getSecretWordDisplay()
    }

    /*fun checkLetter(str:String):String{
        return if(correctGuesses.contains(str)){
            str
        }else{
            "_"
        }
    }*/

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
                _displaySecretWord.value = getSecretWordDisplay()
            }else{
                _incorrectGuesses.value += "$guess "
                _livesLeft.value = _livesLeft.value?.minus(1)
            }
            if(isWon() || isLost()) _gameOver.value = true
        }
    }



    fun isWon() = secretWord.equals(_displaySecretWord.value,true)

    fun isLost() = _livesLeft.value?:0<=0

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

    fun finishGame(){
        _gameOver.value = true
    }

    /*override fun onCleared() {
        super.onCleared()
    }*/


}