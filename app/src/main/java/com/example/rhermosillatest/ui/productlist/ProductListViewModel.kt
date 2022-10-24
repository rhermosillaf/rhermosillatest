package com.example.rhermosillatest.ui.productlist


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rhermosillatest.model.api.ProductApiResponse
import com.example.rhermosillatest.model.api.ProductResult
import com.example.rhermosillatest.service.ProductApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductListViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://us-central1-techtaskapi.cloudfunctions.net/offers/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: ProductApiService = retrofit.create(ProductApiService::class.java)

    val productList = MutableLiveData<List<ProductResult>>()


    fun getProductList(){
        val call = service.getProductList()
        call.enqueue(object : Callback<ProductApiResponse> {
            override fun onResponse(call: Call<ProductApiResponse>, response: Response<ProductApiResponse>) {
                response.body()?.items?.let { list ->
                    productList.postValue(list)
                }
            }
            override fun onFailure(call: Call<ProductApiResponse>, t: Throwable) {
                call.cancel()
            }
        })
    }


}