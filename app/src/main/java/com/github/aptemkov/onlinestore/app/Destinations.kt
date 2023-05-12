package com.github.aptemkov.onlinestore.app

import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val icon: ImageVector?
    val route: String
}
    object LogInDestination : Destination {
        override val icon = null
        override val route = "log_in"
    }
    object SignInDestination : Destination {
        override val icon = null
        override val route = "sign_in"
    }