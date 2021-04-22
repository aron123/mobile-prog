package hu.arondev.uni.mobileprog.core.interactor

import hu.arondev.uni.mobileprog.core.data.DocumentRepository
import hu.arondev.uni.mobileprog.core.domain.Document

class RemoveDocument (private val documentRepository: DocumentRepository) {
    suspend operator fun invoke(document: Document) = documentRepository.removeDocument(document)
}