package com.asadmansoor.jetpup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.asadmansoor.jetpup.ui.detail.PuppyDetailScreen
import com.asadmansoor.jetpup.ui.list.PuppyListScreen
import com.asadmansoor.jetpup.ui.theme.JetPupTheme

@Composable
fun JetPupApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    JetPupTheme {
        NavHost(navController, startDestination = Destinations.PuppyList) {
            composable(Destinations.PuppyList) {
                PuppyListScreen(actions.openPuppyDetail)
            }
            composable(
                "${Destinations.PuppyDetail}/{${Destinations.PuppyDetailArgs.PuppyId}}",
                arguments = listOf(navArgument(Destinations.PuppyDetailArgs.PuppyId) { type = NavType.IntType })
            ) { backStackEntry ->
                PuppyDetailScreen(
                    puppyId = backStackEntry.arguments?.getInt(Destinations.PuppyDetailArgs.PuppyId) ?: 0,
                    actions.navigateBack
                )
            }
        }
    }
}

