package com.example.mvvmflowsquotes.view

sealed class MainViewEvent {
    data class Share(
        val text:String
    ):MainViewEvent()
}