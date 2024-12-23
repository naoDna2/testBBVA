package com.naomi.pruebabbva.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.naomi.pruebabbva.infrastructure.data.local.spreferences.PreferencesManager
import com.naomi.pruebabbva.ui.navigation.NavManager
import com.naomi.pruebabbva.ui.theme.PruebaBbvaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            false
        }
        setContent {
            PruebaBbvaTheme {
                NavManager(preferencesManager)
            }
        }
    }

}
