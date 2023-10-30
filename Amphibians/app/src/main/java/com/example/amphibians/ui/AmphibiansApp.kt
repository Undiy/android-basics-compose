package com.example.amphibians.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibiansHomeScreen
import com.example.amphibians.ui.screens.AmphibiansViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        },
        modifier = modifier
    ) {
        val amphibiansViewModel: AmphibiansViewModel = viewModel()
        AmphibiansHomeScreen(
            amphibiansUiState = amphibiansViewModel.amphibiansUiState,
            retryAction = amphibiansViewModel::getAmphibians,
            modifier = Modifier.padding(it)
        )
    }
}