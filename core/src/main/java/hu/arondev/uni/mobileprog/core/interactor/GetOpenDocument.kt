package hu.arondev.uni.mobileprog.core.interactor

import hu.arondev.uni.mobileprog.core.data.DocumentRepository

class GetOpenDocument (private val repository: DocumentRepository) {
    operator fun invoke() = repository.getOpenDocument()
}