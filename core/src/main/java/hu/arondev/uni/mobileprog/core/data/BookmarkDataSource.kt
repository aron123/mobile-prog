package hu.arondev.uni.mobileprog.core.data

import hu.arondev.uni.mobileprog.core.domain.Bookmark
import hu.arondev.uni.mobileprog.core.domain.Document

interface BookmarkDataSource {
    suspend fun add(document: Document, bookmark: Bookmark)
    suspend fun read(document: Document): List<Bookmark>
    suspend fun remove(document: Document, bookmark: Bookmark)
}