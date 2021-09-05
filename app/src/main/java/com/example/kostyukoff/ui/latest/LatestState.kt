package com.example.kostyukoff.ui.latest

import com.example.kostyukoff.model.LatestsEntity

sealed class LatestState {
    object Loading : LatestState()
    data class Success(val latests: List<LatestsEntity>, val value: Int?) : LatestState()
    object Error : LatestState()
}