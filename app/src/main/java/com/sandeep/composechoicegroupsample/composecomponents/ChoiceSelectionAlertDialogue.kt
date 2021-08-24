package com.sandeep.composechoicegroupsample.composecomponents

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ChoiceSelectionAlertDialogue(
    choiceList: List<String>,
    showDialog: Boolean,
    setShowDialog: (Boolean) -> Unit,
    choiceSelected: Int,
    setChoiceSelected: (Int) -> Unit,
) {

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { setShowDialog(false) },
            title = { Text(text = "Update Today's Purchase Qty") },
            text = {
                ChoiceGroup(
                    choiceList,
                    //To Handle Display Text on Button click for First Time
                    if(choiceSelected < 0) 0 else choiceSelected,
                    setChoiceSelected)
            },
            confirmButton = {
                Button(onClick = {
                    //confirmBtnOnClick(choiceSelected)
                    setShowDialog(false)
                }) {
                    Text(text = "Update")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    setShowDialog(false)
                }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}

@Composable
fun ChoiceGroup(choiceList: List<String>, choiceSelected: Int, setChoiceSelected: (Int) -> Unit) {
    Column(Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
        repeat(choiceList.size) { choice ->
            ChoiceButton(selected = choiceSelected == choice, text = choiceList[choice]) {
                setChoiceSelected(choice)
            }
        }
    }
}

@Composable
fun ChoiceButton(selected: Boolean, text: String, buttonSelected: () -> Unit) {
    val bgColor by animateColorAsState(if (selected) Color.Green else Color.LightGray)
    val textColor by animateColorAsState(if (selected) Color.Blue else Color.White)
    Button(
        onClick = { buttonSelected() }, colors = ButtonDefaults.buttonColors(
            backgroundColor = bgColor, contentColor = Color.White
        ), modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(text = text, color = textColor)
    }
}