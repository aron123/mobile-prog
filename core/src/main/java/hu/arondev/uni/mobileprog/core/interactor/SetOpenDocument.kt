package hu.arondev.uni.mobileprog.core.interactor

import hu.arondev.uni.mobileprog.core.data.DocumentRepository
import hu.arondev.uni.mobileprog.core.domain.Document

class SetOpenDocument (private val documentRepository: DocumentRepository) {
    operator fun invoke(document: Document) = documentRepository.setOpenDocument(document)
}