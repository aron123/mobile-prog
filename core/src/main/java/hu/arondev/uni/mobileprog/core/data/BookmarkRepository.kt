package hu.arondev.uni.mobileprog.core.data

import hu.arondev.uni.mobileprog.core.domain.Bookmark
import hu.arondev.uni.mobileprog.core.domain.Document

class BookmarkRepository (private val dataSource: BookmarkDataSource) {
    suspend fun addBookmark(document: Document, bookmark: Bookmark) = dataSource.add(document, bookmark)
    suspend fun getBookmarks(document: Document) = dataSource.read(document)
    suspend fun removeBookmark(document: Document, bookmark: Bookmark) = dataSource.remove(document, bookmark)
}