package com.rizvandavudov.explorehub.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rizvandavudov.explorehub.domain.model.HomeCategory

@Composable
fun HomeRoute(
    onCategoryClick: (HomeCategory) -> Unit = {},
    viewModel: HomeViewModel = viewModel()
) {
    val uiState: HomeUiState by
    viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        onCategoryClick = onCategoryClick
    )
}