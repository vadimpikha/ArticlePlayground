package com.example.articleplayground.screens

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph
@Destination
@Composable
fun OtherScreen(
    param1: String?,
    param2: Boolean,
    navigator: DestinationsNavigator
) {

    val onNavigateBack = {
        navigator.popBackStack()
    }



}