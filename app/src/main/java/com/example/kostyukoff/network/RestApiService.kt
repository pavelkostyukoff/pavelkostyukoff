package com.example.kostyukoff.network
import com.example.kostyukoff.model.LatestsJson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApiService {
    @GET("{category}/{number}?json=true") //https://developerslife.ru/latest/0?json=true
    suspend fun getLatest(@Path("category") category: String? = "", @Path("number") number: String): Deferred <Response<LatestsJson>> //todo тут изменить запрос

    companion object {
        private val LOG = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun createService(): RestApiService {

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
        }
    }
}