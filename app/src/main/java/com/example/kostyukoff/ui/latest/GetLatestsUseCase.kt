package com.example.kostyukoff.ui.latest

import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.repostitory.LatestsRepository
import kotlinx.coroutines.flow.Flow

class GetLatestsUseCase(private val repository: LatestsRepository) {

    fun getLatests(): Flow<List<LatestsEntity>> {
        return repository.getLatests()
    }
}