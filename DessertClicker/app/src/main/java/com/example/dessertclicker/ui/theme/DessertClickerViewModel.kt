package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {
    private val desserts = Datasource.dessertList

    private val _uiState = MutableStateFlow(DessertClickerUIState(
        currentDessert = determineDessertToShow()
    ))
    val uiState: StateFlow<DessertClickerUIState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        // Update the revenue
        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue + currentState.currentDessert.price,
                dessertsSold = currentState.dessertsSold + 1,
                currentDessert = determineDessertToShow(currentState.dessertsSold)
            )
        }
    }
    /**
     * Determine which dessert to show.
     */
    private fun determineDessertToShow(dessertsSold: Int = 0): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}