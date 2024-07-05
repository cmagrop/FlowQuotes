package com.example.mvvmflowsquotes.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.mvvmflowsquotes.R
import com.example.mvvmflowsquotes.databinding.ActivityMainBinding
import com.example.mvvmflowsquotes.util.shareText
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainViewModel(this)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setupUI() //llama a la interfaz de usuario
        //listenToViewModel() //escuchar los cambios en el ViewModel

    }

    private fun setupUI() = with(binding) {
        quoteBtn.setOnClickListener{viewModel.emitAction(QuoteButtonClick)}
        shareBtn.setOnClickListener{viewModel.emitAction(ShareButtonClick)}

    }

    private fun listenToViewModel()
    {
        //creamos una  corrutina del ciclo de vida de un Activity
        lifecycleScope.launch{
            viewModel.state.flowWithLifecycle(lifecycle).collect{
                render(it)
            }
        }

        lifecycleScope.launch {
            viewModel.viewEvents.flowWithLifecycle(lifecycle).collect{
                handleEvent(it)
            }
        }

    }

    // rendenderizar la vista
    private fun render(state: MainViewState)  = with(binding)
    {
        author.text = state.author
        quote.text= state.quote
        quoteBtn.isEnabled= state.isButtonEnabled
        shareBtn.isEnabled = state.isButtonEnabled
        spinner.visibility= state.spinnerVisibility.value

    }

    private fun handleEvent(event: MainViewEvent)
    {
        when(event)
        {
            is MainViewEvent.Share -> shareText(event.text)
        }

    }




}