package com.rizvandavudov.explorehub.ui.home

import com.rizvandavudov.explorehub.domain.model.HomeCategory

data class HomeUiState(
    val isLoading: Boolean = true,
    val categories: List<HomeCategory> = emptyList(),
    val errorMessage: String? = null
)