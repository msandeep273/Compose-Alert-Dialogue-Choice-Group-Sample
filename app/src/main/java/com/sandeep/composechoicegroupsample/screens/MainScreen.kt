package com.sandeep.composechoicegroupsample.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sandeep.composechoicegroupsample.composecomponents.ChoiceSelectionAlertDialogue

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {

    val (showDialogue, setShowDialogue) = remember { mutableStateOf(false) }

    if (showDialogue) {
        ChoiceSelectionAlertDialogue(
            viewModel.optionsList,
            showDialogue,
            setShowDialogue,
            viewModel.optionChosen,
            viewModel::onOptionUpdated
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            setShowDialogue(true)
            //To Handle first time Button Click
        }) {
            Text(text = "Show Options Dialogue")
        }
        if (viewModel.optionChosen != -1) {
            Text(
                text = "Option Chosen: ${viewModel.optionsList[viewModel.optionChosen]}",
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}