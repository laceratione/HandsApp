package ru.android.handsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.android.handsapp.presentation.main.CelliesViewModel
import ru.android.handsapp.presentation.main.MainScreen
import ru.android.handsapp.ui.theme.HandsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CelliesViewModel by viewModels()
        setContent {
            HandsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}
