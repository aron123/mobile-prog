package hu.arondev.uni.mobileprog.bookmarkapplication

import android.app.Application
import hu.arondev.uni.mobileprog.bookmarkapplication.common.BookmarkViewModelFactory
import hu.arondev.uni.mobileprog.core.data.BookmarkRepository
import hu.arondev.uni.mobileprog.core.data.DocumentRepository
import hu.arondev.uni.mobileprog.core.interactor.*
import hu.arondev.uni.mobileprog.framework.Interactors
import hu.arondev.uni.mobileprog.framework.db.datasource.InMemoryOpenDocumentDataSource
import hu.arondev.uni.mobileprog.framework.db.datasource.RoomBookmarkDataSource
import hu.arondev.uni.mobileprog.framework.db.datasource.RoomDocumentDataSource

class BookmarkApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val bookmarkRepository = BookmarkRepository(RoomBookmarkDataSource (this))
        val documentRepository = DocumentRepository(RoomDocumentDataSource(this), InMemoryOpenDocumentDataSource())

        BookmarkViewModelFactory.inject(this, Interactors(
                AddBookmark(bookmarkRepository),
                GetBookmarks(bookmarkRepository),
                RemoveBookmark(bookmarkRepository),
                AddDocument(documentRepository),
                GetDocuments(documentRepository),
                RemoveDocument(documentRepository),
                GetOpenDocument(documentRepository),
                SetOpenDocument(documentRepository)
        ))
    }
}