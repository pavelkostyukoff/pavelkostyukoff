package com.example.kostyukoff.repostitory

import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.model.LatestsJson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LatestsRepository {
    fun getLatests() : Flow<List<LatestsEntity>>
    @GET("{category}/{number}?json=true")
    fun getLatest(@Path("category") category: String? = "", @Path("number") number: String) : Flow<List<LatestsEntity>>

   // RestApiService
}