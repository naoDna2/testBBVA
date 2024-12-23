package com.naomi.pruebabbva.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naomi.pruebabbva.infrastructure.data.local.spreferences.PreferencesManager
import com.naomi.pruebabbva.ui.screen.home.HomeScreen
import com.naomi.pruebabbva.ui.screen.login.LoginScreen
import com.naomi.pruebabbva.ui.screen.splash.SplashScreen

@Composable
fun NavManager(preferencesManager: PreferencesManager) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen {
                val isLoggedIn = preferencesManager.isLoggedIn()
                if(isLoggedIn){
                    navController.navigate(Home)
                }else{
                    navController.navigate(Login)
                }
            }
        }
        composable<Login> {
            LoginScreen(
                navigateTo = {
                    navController.navigate(Home)
                }
            )
        }
        composable<Home> {
            HomeScreen()
        }
    }
}