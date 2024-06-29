package com.example.mvvmflowsquotes.repository

import android.content.Context
import com.example.mvvmflowsquotes.model.Quote
import com.example.mvvmflowsquotes.util.JsonUtils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class QuoteRepository(private val context: Context,
                      private val moshi: Moshi = Moshi.Builder().build() )
{
    fun getQuotesFromAssets(): List<Quote>
    {
        //a continuacion se llamará al json
        val jsonString = JsonUtils.getJsonFromAssets(context,"quotes.json")
        return getQuotesAdapter().fromJson(jsonString)?: emptyList()

    }

    fun getQuotesAdapter():JsonAdapter<List<Quote>>
    {

        val type = Types.newParameterizedType(List::class.java,Quote::class.java)
        return moshi.adapter(type)

    }



}




