package com.naomi.pruebabbva.application.usescases
import com.naomi.pruebabbva.domain.repositories.AuthRepository
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) : BaseUseCase<Unit, Boolean>() {

    override suspend fun invoke(param: Unit): Boolean {
        val isLoggedIn = authRepository.isLoggedIn()
        return isLoggedIn
    }

}