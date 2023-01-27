package com.example.articleplayground.screens

import androidx.compose.runtime.Composable
import com.example.articleplayground.screens.destinations.OtherScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {

    val navigateToOtherScreen = { param1: String?, param2: Boolean ->
        navigator.navigate(
            OtherScreenDestination(param1, param2)
        )
    }





}