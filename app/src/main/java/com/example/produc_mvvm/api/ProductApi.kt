package com.example.produc_mvvm.api

import com.example.produc_mvvm.model.ProductModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProduct():Response<List<ProductModelItem>>
}