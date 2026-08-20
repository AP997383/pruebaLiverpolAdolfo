package com.example.mobiletechnicaltest.ui.pdp

import android.widget.RatingBar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobiletechnicaltest.R
import com.example.mobiletechnicaltest.domain.model.Product


@Composable
fun ProductDetailScreen(viewModel: ProductDetailViewModel,productId:String){

    LaunchedEffect(Unit) {
        viewModel.getSingleProduct(productId)
    }
    val producto by   remember{ mutableStateOf(Product()) }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = producto.title)
        Text(text  =producto.rating.toString() + "(" + producto.ratingCount +")")
        Text(text  =producto.price.toString(), modifier = Modifier.size(16.dp))
        Text(text  =producto.description)
        Column() {
            Button(modifier = Modifier.fillMaxSize(), onClick = {

            }) {
                Text(text = stringResource(R.string.add_to_cart))
            }
            Button(modifier = Modifier.fillMaxSize(), onClick = {

            }) {
                Text(text = stringResource(R.string.back_to_products))
            }
        }

    }
}