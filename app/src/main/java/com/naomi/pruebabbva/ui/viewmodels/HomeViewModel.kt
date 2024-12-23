package com.naomi.pruebabbva.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naomi.pruebabbva.application.usescases.GetProfileUseCase
import com.naomi.pruebabbva.ui.states.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Init)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        getProfile()
    }

    fun resetState(){
        _uiState.value = UiState.Init
    }

    fun getProfile() = viewModelScope.launch(Dispatchers.Main) {
        try {
            _uiState.value = UiState.Loading
            withContext(Dispatchers.IO){
                val user = getProfileUseCase(Unit)
                _uiState.value = UiState.Success(user)
            }
        }catch (ex:Exception){
            Log.e("HomeViewModel", "Error authUseCase", ex)
            _uiState.value = UiState.Error("No se puede iniciar sesión")
        }
    }

}