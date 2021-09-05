package com.example.kostyukoff.model

import com.google.gson.annotations.SerializedName

class LatestJson(
    @SerializedName("author")
    val author: String, // w3lifer
    @SerializedName("canVote")
    val canVote: Boolean, // false
    @SerializedName("commentsCount")
    val commentsCount: Int, // 0
    @SerializedName("date")
    val date: String, // May 17, 2021 12:47:20 PM
    @SerializedName("description")
    val description: String, // Накануне дедлайна
    @SerializedName("fileSize")
    val fileSize: Int, // 637391
    @SerializedName("gifSize")
    val gifSize: Int, // 637391
    @SerializedName("gifURL")
    val gifURL: String, // http://static.devli.ru/public/images/gifs/202105/338eec95-f956-4aa6-8844-219166979cc2.gif
    @SerializedName("height")
    val height: String, // 154
    @SerializedName("id")
    val id: Int, // 17088
    @SerializedName("previewURL")
    val previewURL: String, // https://static.devli.ru/public/images/previews/202105/338eec95-f956-4aa6-8844-219166979cc2.jpg
    @SerializedName("type")
    val type: String, // gif
    @SerializedName("videoPath")
    val videoPath: String, // /public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4
    @SerializedName("videoSize")
    val videoSize: Int, // 172526
    @SerializedName("videoURL")
    val videoURL: String, // http://static.devli.ru/public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4
    @SerializedName("votes")
    val votes: Int, // 5
    @SerializedName("width")
    val width: String // 232
)