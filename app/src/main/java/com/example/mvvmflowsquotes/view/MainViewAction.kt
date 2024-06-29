package com.example.mvvmflowsquotes.view

    sealed class MainViewAction //completa de la clase
    object QuoteButtonClick:MainViewAction() //crear un objeto de tipo MainViewAction
    object ShareButtonClick:MainViewAction()