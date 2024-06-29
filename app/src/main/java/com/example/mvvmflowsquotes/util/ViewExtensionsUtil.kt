package com.example.mvvmflowsquotes.util

import android.app.Activity
import android.content.Intent

fun Activity.shareText(text:String)
{
    val sendIntent = Intent().apply {

        action = Intent.ACTION_SEND //compartir
        putExtra(Intent.EXTRA_TEXT,text)
        type = "text/plain"

    }

    val shareIntent = Intent.createChooser(sendIntent,null)
    startActivity(shareIntent)

}