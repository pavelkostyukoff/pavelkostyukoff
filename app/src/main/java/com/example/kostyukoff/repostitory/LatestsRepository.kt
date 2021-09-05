package com.example.kostyukoff.repostitory

import com.example.kostyukoff.model.LatestsEntity
import kotlinx.coroutines.flow.Flow

interface LatestsRepository {
    fun getLatests() : Flow<List<LatestsEntity>>

   // RestApiService
}