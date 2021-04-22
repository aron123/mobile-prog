package hu.arondev.uni.mobileprog.core.data

import hu.arondev.uni.mobileprog.core.domain.Document

interface DocumentDataSource {
    suspend fun add(document: Document)
    suspend fun readAll(): List<Document>
    suspend fun remove(document: Document)
}