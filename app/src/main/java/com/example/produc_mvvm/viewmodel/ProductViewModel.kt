package com.example.produc_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produc_mvvm.model.ProductModelItem
import com.example.produc_mvvm.repositry.ProductRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(val repositry: ProductRepositry):ViewModel() {
    val product:StateFlow<List<ProductModelItem>>
        get() =repositry.products

    init {
        viewModelScope.launch {
            repositry.getProduct()
        }

    }
}