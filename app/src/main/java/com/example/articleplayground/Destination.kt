package com.example.articleplayground

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(val path: String, val args: List<NamedNavArgument>) {

    object Home : Destination("home", emptyList())

    object OtherScreen : Destination(
        path = "other_screen?param1={param1}&param2={param2}",
        args = listOf(
            navArgument("param1") {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            },
            navArgument("param2") {
                type = NavType.BoolType
                defaultValue = false
            }
        )
    ) {

        class Arguments(val param1: String?, val param2: Boolean)

        fun getRoute(arguments: Arguments): String {
            return "other_screen?param1=${arguments.param1},param2=${arguments.param2}"
        }

        fun getArguments(bundle: Bundle): Arguments {
            return Arguments(
                param1 = bundle.getString("param1"),
                param2 = bundle.getBoolean("param2")
            )
        }
    }
}
