package com.example.kronometreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.kronometreapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var zamaniDurdur:Long = 0
        binding.buttonStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
            binding.kronometre.start()
            binding.buttonStart.visibility = View.GONE
            binding.buttonPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }

        binding.buttonPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        binding.buttonReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }




    }
}