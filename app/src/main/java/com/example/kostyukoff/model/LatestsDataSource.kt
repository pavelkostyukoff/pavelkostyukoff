package com.example.kostyukoff.model


interface LatestsDataSource {
    suspend fun getLatests(): List<LatestsEntity>
}