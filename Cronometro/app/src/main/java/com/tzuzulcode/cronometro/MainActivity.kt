package com.tzuzulcode.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import com.tzuzulcode.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    lateinit var stopwatch: Chronometer
    var running = false
    var offset:Long = 0

    val RUNNING_KEY = "running"
    val OFFSET_KEY = "offset"
    val BASE_KEY = "base"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        stopwatch = findViewById(R.id.stopwatch)

        //Restaurando estado anterior
        if(savedInstanceState!=null){
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            if(running){
                stopwatch.base = savedInstanceState.getLong(BASE_KEY)
                stopwatch.start()
            }else{
                setBaseTime()
            }
        }

        //val startButton = findViewById<Button>(R.id.start_button)
        //val pauseButton = findViewById<Button>(R.id.pause_button)
        //val resetButton = findViewById<Button>(R.id.reset_button)

        binding.startButton.setOnClickListener {
            if(!running){
                setBaseTime()
                stopwatch.start()
                running = true
            }
        }

        binding.pauseButton.setOnClickListener {
            if(running){
                saveOffset()
                stopwatch.stop()
                running = false
            }
        }

        binding.resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }

    }

    override fun onPause() {
        super.onPause()
        if(running){
            saveOffset()
            stopwatch.stop()

        }
    }

    override fun onResume() {
        super.onResume()
        if(running){
            setBaseTime()
            stopwatch.start()
            offset=0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY,running)
        outState.putLong(OFFSET_KEY,offset)
        outState.putLong(BASE_KEY,stopwatch.base)
        super.onSaveInstanceState(outState)
    }

    fun setBaseTime(){
        stopwatch.base = SystemClock.elapsedRealtime() - offset
    }
    fun saveOffset(){
        offset = SystemClock.elapsedRealtime() - stopwatch.base // stopwatch.base: hora de inicio el cronometro
    }
}