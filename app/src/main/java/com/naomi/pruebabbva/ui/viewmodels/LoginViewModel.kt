package com.naomi.pruebabbva.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naomi.pruebabbva.application.params.AuthParams
import com.naomi.pruebabbva.application.usescases.AuthUseCase
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
class LoginViewModel  @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Init)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun resetState(){
        _uiState.value = UiState.Init
    }

    fun login(navigateTo: () -> Unit, user:String, pass:String) = viewModelScope.launch(Dispatchers.Main) {
        try {
            _uiState.value = UiState.Loading
            val param = AuthParams(user,pass)
            withContext(Dispatchers.IO){authUseCase(param)}
            _uiState.value = UiState.Success(Unit)
            navigateTo()
        }catch (ex:Exception){
            Log.e("LoginViewModel", "Error authUseCase", ex)
            _uiState.value = UiState.Error("No se puede iniciar sesión")
        }
    }

}