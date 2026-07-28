package com.rury.profilemahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rury.profilemahasiswa.screens.DataNilaiScreen
import com.rury.profilemahasiswa.screens.ProfileEditScreen
import com.rury.profilemahasiswa.screens.ProfileScreen
import com.rury.profilemahasiswa.ui.theme.ProfilMahasiswaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: ProfileViewModel = viewModel()
            var currentScreen by remember { mutableStateOf("profile") }
            var isDarkMode by remember { mutableStateOf(false) }

            ProfilMahasiswaTheme(darkTheme = isDarkMode) {
                when (currentScreen) {
                    "profile" -> ProfileScreen(
                        viewModel = viewModel,
                        isDarkMode = isDarkMode,
                        onToggleDarkMode = { isDarkMode = it },
                        onNavigateToEdit = { currentScreen = "edit" },
                        onNavigateToNilai = { currentScreen = "nilai" }
                    )
                    "edit" -> ProfileEditScreen(
                        viewModel = viewModel,
                        onNavigateBack = { currentScreen = "profile" }
                    )
                    "nilai" -> DataNilaiScreen(
                        viewModel = viewModel,
                        onNavigateBack = { currentScreen = "profile" }
                    )
                }
            }
        }
    }
}
