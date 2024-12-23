package com.naomi.pruebabbva.application.usescases

abstract class BaseUseCase<in I, out O> {
    abstract suspend operator fun invoke(param:I): O
}
