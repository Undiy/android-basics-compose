package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composeTestRule.onNodeWithStringId(
            R.string.subtotal_price,
            subtotal
        ).assertIsDisplayed()

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    @Test
    fun startOrderScreen_verifyContent() {
        composeTestRule.setContent {
            StartOrderScreen(quantityOptions = DataSource.quantityOptions, onNextButtonClicked = {})
        }

        composeTestRule.onNodeWithStringId(R.string.order_cupcakes).assertIsDisplayed()

        DataSource.quantityOptions.forEach {
            composeTestRule.onNodeWithStringId(it.first).assertIsDisplayed().assertIsEnabled()
        }
    }

    @Test
    fun summaryScreen_verifyContent() {
        val orderUiState = OrderUiState(
            quantity = 1,
            flavor = "Vanilla",
            date = getFormattedDate(),
            price = "$100"
        )

        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = orderUiState,
                onCancelButtonClicked = {},
                onSendButtonClicked = {_, _ -> }
            )
        }

        val numberOfCupcakes = composeTestRule.activity.resources.getQuantityString(
            R.plurals.cupcakes,
            orderUiState.quantity,
            orderUiState.quantity
        )

        listOf(numberOfCupcakes, orderUiState.flavor, orderUiState.date).forEach {
            composeTestRule.onNodeWithText(it).assertIsDisplayed()
        }
        composeTestRule.onNodeWithStringId(R.string.subtotal_price, orderUiState.price)
            .assertIsDisplayed()

        listOf(R.string.send, R.string.cancel).forEach {
            composeTestRule.onNodeWithStringId(it).assertIsDisplayed().assertIsEnabled()
        }
    }

    @Test
    fun selectOptionScreen_optionSelected_nextButtonEnabled() {
        val option = "test"

        composeTestRule.setContent {
            SelectOptionScreen(subtotal = "", options = listOf(option))
        }

        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()

        composeTestRule.onNodeWithText(option).performClick()

        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()
    }
}