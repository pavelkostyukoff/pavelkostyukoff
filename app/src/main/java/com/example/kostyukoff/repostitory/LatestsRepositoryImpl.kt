package com.example.kostyukoff.repostitory

import com.example.kostyukoff.model.LatestsDataSource
import com.example.kostyukoff.model.LatestsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LatestsRepositoryImpl(private val localDataSource: LatestsDataSource) : LatestsRepository {
    override fun getLatests(): Flow<List<LatestsEntity>> {
        return flow {
            emit(localDataSource.getLatests())
        }.flowOn(Dispatchers.IO) as Flow<List<LatestsEntity>>
    }
}