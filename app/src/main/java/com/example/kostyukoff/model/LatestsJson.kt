package com.example.kostyukoff.model

import com.google.gson.annotations.SerializedName

class LatestsJson {
    @SerializedName("result")
    val results: List<LatestJson>? = null
    @SerializedName("totalCount")
    val totalCount: Int = 0
}