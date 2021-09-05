package com.example.kostyukoff.ui.latest

import androidx.lifecycle.MutableLiveData
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.network.RestApiService

import kotlinx.coroutines.*
import retrofit2.HttpException

class LatestsRepository() {

    private var latestPost = listOf<LatestsEntity>()
    private var mutableLiveData = MutableLiveData<List<LatestsEntity>>()
    private val CATEGORY = "latest"
    private val NUMBER_PAGE = "0"

    val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private val thisApiService by lazy {
        RestApiService.createService()
    }

    fun getMutableLiveData():MutableLiveData<List<LatestsEntity>> {
        coroutineScope.launch {
            val request = thisApiService.getLatest(CATEGORY,NUMBER_PAGE)
            withContext(Dispatchers.Main) {
                try {
                    val newsWrapper = request.await()
                /*    if (newsWrapper.results != null) {
                        movies = newsWrapper.results as MutableList<LatestsEntity>
                        mutableLiveData.value=movies
                    }*/

                } catch (e: HttpException) {
                    e
                    // Log exception //
                } catch (e: Throwable) {
                    e
                    // Log error //)
                }
            }
        }
        return mutableLiveData
    }
}