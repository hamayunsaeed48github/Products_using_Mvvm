package com.example.produc_mvvm.repositry

import com.example.produc_mvvm.api.ProductApi
import com.example.produc_mvvm.model.ProductModelItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRepositry @Inject constructor(private val productApi: ProductApi) {

    val _products = MutableStateFlow<List<ProductModelItem>>(emptyList())
    val products:StateFlow<List<ProductModelItem>>
        get()=_products

    suspend fun getProduct(){
        val response = productApi.getProduct()
        if(response.isSuccessful && response.body() != null){
            _products.emit(response.body()!!)
        }
    }
}