package com.example.kostyukoff.repostitory

import com.example.kostyukoff.model.LatestsDataSource
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.model.LatestsJson
import com.example.kostyukoff.network.RestApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

class LatestsRepositoryImpl(private val servise: RestApiService) : LatestsRepository {
    override fun getLatests(): Flow<List<LatestsEntity>> {
        return flow {
            emit(servise.getLatest("latest", "0"))
        }.flowOn(Dispatchers.IO) as Flow<List<LatestsEntity>>
    }

    override fun getLatest(category: String?, number: String): Flow<List<LatestsEntity>>{
        return flow {
            emit(servise.getLatest("latest", "0"))
        }.flowOn(Dispatchers.IO) as Flow<List<LatestsEntity>>
    }

    companion object {/*   private val LOG = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun createService(): LatestsRepositoryImpl {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(LOG)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://developerslife.ru/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(RestApiService::class.java)
        }*/

    }
}