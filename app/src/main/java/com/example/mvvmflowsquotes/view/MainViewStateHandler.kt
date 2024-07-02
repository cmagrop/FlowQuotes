package com.example.mvvmflowsquotes.view

import com.example.mvvmflowsquotes.model.Quote

class MainViewStateHandler {
    fun handleInitialState() =  MainViewState(
        author = "obteniendo información",
        quote =  "obteniendo reseña",
        spinnerVisibility =  VisibilityState.GONE,
        isButtonEnabled = true

    )

    fun handleLoadingState( currentState: MainViewState) =
        currentState.copy(
            spinnerVisibility = VisibilityState.VISIBLE,
            isButtonEnabled = false
        )

    fun handleSuccess( quote: Quote ) = MainViewState(
        author = quote.author,
        quote =  quote.content,
        spinnerVisibility =  VisibilityState.GONE,
        isButtonEnabled = true
    )




}