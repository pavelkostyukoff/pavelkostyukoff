package com.example.kostyukoff.repostitory

import com.example.kostyukoff.model.LatestsDataSource
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.network.RestApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LatestsRepositoryImpl(private val servise: RestApiService) : LatestsRepository {
    override fun getLatests(): Flow<List<LatestsEntity>> {
        return flow {
            emit(servise.getLatest("latest", "0"))
        }.flowOn(Dispatchers.IO) as Flow<List<LatestsEntity>>
    }
}