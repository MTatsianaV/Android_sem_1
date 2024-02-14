package com.mortatval.buss

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.mortatval.buss.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        var passengerCount = 0
        var availableSeats = 49
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.passengerTextView.text = passengerCount.toString()
        binding.seatsTextView.text = "Все места свободны"
        binding.seatsTextView.setTextColor(Color.GREEN)
        binding.resetButton.visibility = View.INVISIBLE
        binding.minusButton.visibility = View.INVISIBLE


        binding.minusButton.setOnClickListener {
            if (passengerCount > 1) {
                binding.minusButton.visibility = View.VISIBLE
                passengerCount--
                availableSeats++
                binding.seatsTextView.text = "Свободно мест: $availableSeats"
                binding.seatsTextView.setTextColor(Color.BLUE)
                binding.passengerTextView.text = passengerCount.toString()
            }
            else if (passengerCount == 1) {
                passengerCount--
                availableSeats++
                binding.minusButton.visibility = View.INVISIBLE
                binding.seatsTextView.text = "Все места свободны"
                binding.seatsTextView.setTextColor(Color.GREEN)
                binding.passengerTextView.text = passengerCount.toString()
            }
        }

        binding.plusButton.setOnClickListener {
            if (passengerCount == 0) {
                binding.minusButton.visibility = View.VISIBLE
                passengerCount++
                availableSeats--
                binding.seatsTextView.text = "Свободно мест: $availableSeats"
                binding.seatsTextView.setTextColor(Color.BLUE)
                binding.passengerTextView.text = passengerCount.toString()
            }
            else if (passengerCount < 49 && passengerCount >0) {
                binding.minusButton.visibility = View.VISIBLE
                passengerCount++
                availableSeats--
                binding.seatsTextView.text = "Свободно мест: $availableSeats"
                binding.seatsTextView.setTextColor(Color.BLUE)
                binding.passengerTextView.text = passengerCount.toString()
            }
            else {
                passengerCount = 50
                binding.seatsTextView.text = "Слишком много пассажиров!"
                binding.seatsTextView.setTextColor(Color.RED)
                binding.passengerTextView.text = passengerCount.toString()
                binding.passengerTextView.setTextColor(Color.RED)
                binding.resetButton.visibility = View.VISIBLE
                binding.minusButton.visibility = View.INVISIBLE
            }
        }

        binding.resetButton.setOnClickListener {
            passengerCount = 0
            availableSeats = 49
            binding.passengerTextView.text = passengerCount.toString()
            binding.passengerTextView.setTextColor(Color.BLACK)
            binding.seatsTextView.text = "Все места свободны"
            binding.seatsTextView.setTextColor(Color.GREEN)
            binding.resetButton.visibility = View.INVISIBLE
            binding.minusButton.visibility = View.INVISIBLE
        }
    }
}