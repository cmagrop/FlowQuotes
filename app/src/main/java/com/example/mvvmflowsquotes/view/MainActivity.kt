package com.example.mvvmflowsquotes.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvvmflowsquotes.R
import com.example.mvvmflowsquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //llamar setupUI
        //llamar listenToViewModel

    }

    private fun setupUI() = with(binding) {
        //quoteBtn.setOnClickListener{viewModel.emitAction(QuoteButtonClick)}
        //shareBtn.setOnClickListener{viewModel.emitAction(ShareButtonClick)}

    }

    private fun listenToViewModel()
    {

    }

    private fun render() //completar
    {

    }

    private fun handleEvent()
    {

    }




}