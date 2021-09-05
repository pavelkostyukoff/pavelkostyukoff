package com.example.local

import android.content.Context
import com.example.kostyukoff.R
import com.example.kostyukoff.model.LatestsDataSource
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.model.LatestsJson
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
/*

class LocalDataSource(private val context: Context) : LatestsDataSource {
    override suspend fun getLatests(): List<LatestsEntity>? {
        val raw: InputStream = context.resources.openRawResource(R.raw.markers)
        val rd: Reader = BufferedReader(InputStreamReader(raw))
        val gson = Gson()
        val cityJson = gson.fromJson(rd, LatestsJson::class.java)
        return cityJson.results?.map {
            LatestsEntity(it.id, it.gifURL, it.description,it.previewURL)
        }
    }

    //todo для чего - создан класс - будет отдавать список маркеров из локального джейсона
}*/
