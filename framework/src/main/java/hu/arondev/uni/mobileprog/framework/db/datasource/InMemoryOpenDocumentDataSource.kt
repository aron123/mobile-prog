package hu.arondev.uni.mobileprog.framework.db.datasource

import hu.arondev.uni.mobileprog.core.data.DocumentDataSource
import hu.arondev.uni.mobileprog.core.data.OpenDocumentDataSource
import hu.arondev.uni.mobileprog.core.domain.Document

class InMemoryOpenDocumentDataSource : OpenDocumentDataSource {
    private var openDocument: Document = Document.EMPTY

    override fun setOpenDocument(document: Document) {
        openDocument = document
    }

    override fun getOpenDocument(): Document = openDocument
}