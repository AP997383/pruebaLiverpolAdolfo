package com.example.mobiletechnicaltest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.mobiletechnicaltest.ui.pdp.ProductDetailViewModel
import com.example.mobiletechnicaltest.ui.plp.ProductListViewModel
import com.example.mobiletechnicaltest.ui.plp.productListScreen

@Composable
fun NavHostPrueba(
    navController: NavHostController,
    startDestination:String,
    productListViewModel: ProductListViewModel,
    productDetailViewModel: ProductDetailViewModel
){
    NavHost(
        navController=navController,
        startDestination =startDestination,
        modifier = Modifier.fillMaxWidth()
        ){
        composable(Routes.ScreenList.route){
            productListScreen(productListViewModel,{
                navController.navigate(Routes.ScreenDetail.route +"/$it")
            })
        }
        composable(Routes.ScreenDetail.route+"{params}",
            arguments = listOf(

            )){
            productListScreen(productListViewModel,{
                navController.navigate(Routes.ScreenDetail.route +"/$it")
            })
        }
    }
}