package com.asadmansoor.jetpup

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

object Destinations {
    const val PuppyList = "puppyList"
    const val PuppyDetail = "puppyDetail"

    object PuppyDetailArgs {
        const val PuppyId = "puppyId"
    }
}

class Actions(navController: NavHostController) {
    val openPuppyDetail: (Int) -> Unit = { puppyId ->
        navController.navigate("${Destinations.PuppyDetail}/$puppyId")
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}
