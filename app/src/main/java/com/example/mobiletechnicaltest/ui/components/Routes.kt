package com.example.mobiletechnicaltest.ui.components

sealed class Routes(val route: String) {
    object ScreenDetail : Routes("Detail")
    object ScreenList : Routes("List")
}