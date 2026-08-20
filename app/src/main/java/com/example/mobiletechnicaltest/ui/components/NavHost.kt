package com.example.mobiletechnicaltest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mobiletechnicaltest.ui.pdp.ProductDetailScreen
import com.example.mobiletechnicaltest.ui.pdp.ProductDetailViewModel
import com.example.mobiletechnicaltest.ui.plp.ProductListScreen
import com.example.mobiletechnicaltest.ui.plp.ProductListViewModel


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
            ProductListScreen(productListViewModel,{
                navController.navigate(Routes.ScreenDetail.route +"/$it")
            })
        }
        composable(Routes.ScreenDetail.route+"/{params}",
            arguments = listOf(
                navArgument("params") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )){ params->
            val id = params.arguments?.getString("params") ?: ""
            ProductDetailScreen(productDetailViewModel,id,{navController.popBackStack()},{})
        }
    }
}