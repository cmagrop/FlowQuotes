package com.example.mvvmflowsquotes.view

import android.view.View

data class MainViewState(

    val author: String,
    val quote: String

)

enum class VisibilityState(val value: Int)
{
    VISIBLE(View.VISIBLE),
    GONE(View.GONE)

}
