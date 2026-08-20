package com.example.mobiletechnicaltest.ui.main
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.mobiletechnicaltest.ui.components.NavHostPrueba
import com.example.mobiletechnicaltest.ui.components.Routes
import com.example.mobiletechnicaltest.ui.pdp.ProductDetailViewModel
import com.example.mobiletechnicaltest.ui.plp.ProductListViewModel
import com.example.mobiletechnicaltest.ui.theme.LiverPoolTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiverPoolTheme (
                darkTheme = false,
                dynamicColor = false) {
                val navController = rememberNavController()
                var startDestination by remember { mutableStateOf<String?>(null) }
                val productsList: ProductListViewModel by viewModels()
                val productsDetail: ProductDetailViewModel by viewModels()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()) { innerPadding ->
                    NavHostPrueba(
                        navController = navController,
                        startDestination = Routes.ScreenList.route,
                        productsList,
                        productsDetail
                    )
                }
            }
        }
    }
}
