package com.example.mvvmflowsquotes.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmflowsquotes.interactor.GetQuoteInteractor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

//conecta la Vista con el Modelo
class MainViewModel
    (context: Context,
     private val interactor: GetQuoteInteractor = GetQuoteInteractor(context),
     private val stateHandler: MainViewStateHandler = MainViewStateHandler()): ViewModel()
    {
         //atributos de MainViewModel
         private val viewEventsChannel= Channel<MainViewEvent>(Channel.BUFFERED)
         private val mutableState: MutableStateFlow<MainViewState> =
             MutableStateFlow(stateHandler.handleInitialState()) //estamos estableciendo el estado inicial del ciclo

        val state = mutableState.asStateFlow()  // establece estado cambiante como un flujo de estados
        val viewEvents = viewEventsChannel.receiveAsFlow() //recibe los eventos como un flujo

        init {
            fetchNewQuote()

        }



        fun emitAction(action: MainViewAction)
        {
            when(action)
            {
                QuoteButtonClick -> fetchNewQuote()
                ShareButtonClick -> shareQuote(state.value.author,state.value.quote)

            }

            /*
            * switch(action)
            * {
            *  case QuoteButtonClick:
            *  fectNewQuote
            * case ShareButtonClick:
            * shareQuote(state.value.author,state.value.quote)
            *
            * }
            * */

        }

        private fun shareQuote(author: String, quote: String) {

            emitViewEvent(
                MainViewEvent.Share("$author: $quote")
            )

        }

        private fun emitViewEvent(event: MainViewEvent) = viewModelScope.launch {

            viewEventsChannel.send(event)

        }


        private fun fetchNewQuote() {

            viewModelScope.launch {

                emitState(stateHandler.handleLoadingState(state.value))
                val quote = interactor.getQuote()
                emitState(stateHandler.handleSuccess(quote))

            }
//
        }

        private fun emitState(state: MainViewState) {

            mutableState.value = state

        }


    }
