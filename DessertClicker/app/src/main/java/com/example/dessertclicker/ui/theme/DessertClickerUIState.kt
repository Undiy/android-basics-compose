package com.example.dessertclicker.ui.theme

import com.example.dessertclicker.model.Dessert

data class DessertClickerUIState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessert: Dessert
)