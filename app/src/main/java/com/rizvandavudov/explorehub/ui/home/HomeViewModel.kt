package com.rizvandavudov.explorehub.ui.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.rizvandavudov.explorehub.data.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel (
    private val repository: HomeRepository = HomeRepository()
) : ViewModel (){

    private val _uiState = MutableStateFlow(
        HomeUiState()
    )
    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()
    init {
        loadCategories()
    }
    private fun loadCategories() {
        try {
            val categories = repository.getCategoies()
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                categories = categories,
                errorMessage = null
            )
        }catch (exception : Exception){
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                categories = emptyList(),
                errorMessage = "Kateqoriyalar ywklenmedi"
            )
        }
    }
}