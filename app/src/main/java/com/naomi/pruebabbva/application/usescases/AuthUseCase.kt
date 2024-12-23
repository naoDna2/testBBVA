package com.naomi.pruebabbva.application.usescases
import com.naomi.pruebabbva.application.params.AuthParams
import com.naomi.pruebabbva.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) : BaseUseCase<AuthParams, Unit>() {

    override suspend fun invoke(param: AuthParams) {
        authRepository.login(
            user = param.user,
            pass = param.pass,
        )
    }
}