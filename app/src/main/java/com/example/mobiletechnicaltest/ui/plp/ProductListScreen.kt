package com.example.mobiletechnicaltest.ui.plp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mobiletechnicaltest.R
import com.example.mobiletechnicaltest.domain.model.Product
import kotlin.collections.mutableListOf


@Composable
fun productListScreen(productListViewModel: ProductListViewModel,openDetailProduct:(Int)->Unit){
    val productos =  remember { mutableListOf(Product()) }

    LaunchedEffect(Unit) {
        productListViewModel.getAllProducts()
    }


    Scaffold(
        topBar = {

        }
    ) { InnerPadding->
        Column(modifier = Modifier.padding(InnerPadding)) {
            LazyRow() {
                productos.forEach {
                    item {
                        Card(modifier = Modifier.fillMaxWidth().clickable{
                            openDetailProduct(it.id)
                        }) {
                            Row() {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    contentDescription = "Image Product",

                                )

                                Row (modifier = Modifier.weight(2f)) {
                                    Column() {
                                        Text(it.category)
                                        Text(it.title)
                                        Text(it.price.toString())
                                    }
                                }
                                Row() {
                                   Image( imageVector = painterResource(Icons.Default.Star), modifier = Modifier.width(20.dp), contentDescription = "Icon Star")
                                    Text(it.rating.toString() + "(" + it.ratingCount +")")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}