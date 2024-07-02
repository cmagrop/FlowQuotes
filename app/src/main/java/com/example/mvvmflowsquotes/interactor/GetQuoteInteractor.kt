package com.example.mvvmflowsquotes.interactor

import android.content.Context
import android.icu.util.DateInterval
import com.example.mvvmflowsquotes.model.Quote
import com.example.mvvmflowsquotes.repository.QuoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GetQuoteInteractor(context:Context,
                         private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
                         private val repository: QuoteRepository = QuoteRepository(context),
                         private val loadingIntervalMs: Long = 3000)
{

    /*suspend: se trabaja con corrutinas y le da la capacidad de iniciar, pausar y reanudar
     la corrutina. De forma interna realiza los llamados necesarios a una corrutina
     */

    suspend fun getQuote(): Quote =
        withContext(ioDispatcher)
        {
            delay(loadingIntervalMs)
            repository.getQuotesFromAssets().random()
        }




}