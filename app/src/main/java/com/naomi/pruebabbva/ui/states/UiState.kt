package com.naomi.pruebabbva.ui.states

sealed class UiState {
    data object Init : UiState()
    data object Loading : UiState()
    data class Success<T>(val data: T) : UiState()
    data class Error(val message: String) : UiState()
}