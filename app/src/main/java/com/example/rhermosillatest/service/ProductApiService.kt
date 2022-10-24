package com.example.rhermosillatest.service

import com.example.rhermosillatest.model.api.ProductApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiService {
        @GET(".")
        fun getProductList(): Call<ProductApiResponse>

}