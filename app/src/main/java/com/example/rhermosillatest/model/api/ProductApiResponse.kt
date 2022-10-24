package com.example.rhermosillatest.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductApiResponse (
    @Expose @SerializedName("page") val page: Int,
    @Expose @SerializedName("pageSize") val pageSize: Int,
    @Expose @SerializedName("total") val total: Int,
    @Expose @SerializedName("items") val items: List<ProductResult>
)

data class ProductResult (
    @Expose @SerializedName("id") val id: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("image") val image: String,
    @Expose @SerializedName("price") val price: Int
    )