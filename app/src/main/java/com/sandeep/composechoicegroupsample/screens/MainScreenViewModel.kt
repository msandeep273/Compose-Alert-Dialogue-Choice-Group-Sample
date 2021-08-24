package com.sandeep.composechoicegroupsample.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainScreenViewModel: ViewModel() {
    var optionChosen by mutableStateOf(-1)

    val optionsList = listOf("One", "Two","Three","Four")

    fun onOptionUpdated(newOption:Int){
        optionChosen = newOption
    }
}