package com.example.kostyukoff.model

import com.google.gson.annotations.SerializedName

class LatestsJson {
    @SerializedName("result")
    val latest : List<LatestJson> = emptyList()

    @SerializedName("totalCount")
    val totalCount: Int = 0
}