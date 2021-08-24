package com.sandeep.composechoicegroupsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.sandeep.composechoicegroupsample.screens.MainScreen
import com.sandeep.composechoicegroupsample.screens.MainScreenViewModel
import com.sandeep.composechoicegroupsample.ui.theme.ComposeChoiceGroupSampleTheme

class MainActivity : ComponentActivity() {
    private val mainScreenViewModel by viewModels<MainScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChoiceGroupSampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(mainScreenViewModel)
                }
            }
        }
    }
}

