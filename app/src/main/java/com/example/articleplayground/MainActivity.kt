package com.example.articleplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.articleplayground.screens.HomeScreen
import com.example.articleplayground.screens.OtherScreen
import com.example.articleplayground.ui.theme.ArticlePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Destination.Home.path
                    ) {
                        composable(route = Destination.Home.path) {
                            HomeScreen(
                                onNavigateToOtherScreen = { param1, param2 ->
                                    val route = Destination.OtherScreen.getRoute(
                                        Destination.OtherScreen.Arguments(
                                            param1 = param1,
                                            param2 = param2
                                        )
                                    )
                                    navController.navigate(route)
                                }
                            )
                        }

                        composable(
                            route = Destination.OtherScreen.path,
                            arguments = Destination.OtherScreen.args
                        ) { backStackEntry ->

                            val args = Destination.OtherScreen.getArguments(
                                bundle = requireNotNull(backStackEntry.arguments)
                            )

                            OtherScreen(
                                param1 = args.param1,
                                param2 = args.param2,
                                onNavigateBack = { navController.popBackStack() }
                            )
                        }
                    }

                }
            }
        }
    }
}

