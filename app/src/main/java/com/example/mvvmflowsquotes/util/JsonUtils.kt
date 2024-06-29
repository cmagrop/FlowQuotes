package com.example.mvvmflowsquotes.util

import android.content.Context

object JsonUtils {

    fun getJsonFromAssets(context: Context,filename:String):String =
        context.assets.open(filename).bufferedReader().use { it.readText() }

}