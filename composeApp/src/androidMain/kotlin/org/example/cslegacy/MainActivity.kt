package org.example.cslegacy


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import navigation.SetupNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetupNavigation()
        }
    }
}
