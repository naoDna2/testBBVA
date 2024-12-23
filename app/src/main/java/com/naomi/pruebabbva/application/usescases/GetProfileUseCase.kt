package com.naomi.pruebabbva.application.usescases
import com.naomi.pruebabbva.domain.entities.User
import com.naomi.pruebabbva.domain.repositories.AuthRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) : BaseUseCase<Unit, User>() {

    override suspend fun invoke(param: Unit): User {
        val user = authRepository.getProfile()
        return user
    }

}