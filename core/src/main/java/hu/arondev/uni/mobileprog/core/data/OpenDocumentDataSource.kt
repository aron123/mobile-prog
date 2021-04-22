package hu.arondev.uni.mobileprog.core.data

import hu.arondev.uni.mobileprog.core.domain.Document

interface OpenDocumentDataSource {
    fun setOpenDocument(document: Document)
    fun getOpenDocument(): Document
}
