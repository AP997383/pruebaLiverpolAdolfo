package com.example.mobiletechnicaltest.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.core.app.ComponentActivity
import androidx.navigation.compose.rememberNavController
import com.example.mobiletechnicaltest.databinding.ActivityMainBinding
import com.example.mobiletechnicaltest.ui.components.NavHostPrueba
import com.example.mobiletechnicaltest.ui.components.Routes
import com.example.mobiletechnicaltest.ui.pdp.ProductDetailViewModel
import com.example.mobiletechnicaltest.ui.plp.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : androidx.activity.ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val productListViewModel: ProductListViewModel by viewModels()
            val productDetailViewModel: ProductDetailViewModel by viewModels()
            Scaffold(){innerPadding->
                NavHostPrueba(
                    navController = navController,
                    startDestination = Routes.ScreenList.route,
                    productListViewModel =productListViewModel,
                    productDetailViewModel =productDetailViewModel
                )
            }
        }
    }
}
