package hu.arondev.uni.mobileprog.core.interactor

import hu.arondev.uni.mobileprog.core.data.BookmarkRepository
import hu.arondev.uni.mobileprog.core.domain.Bookmark
import hu.arondev.uni.mobileprog.core.domain.Document

class AddBookmark (private val bookmarkRepository: BookmarkRepository) {
    suspend operator fun invoke(document: Document, bookmark: Bookmark) = bookmarkRepository.addBookmark(document, bookmark)
}