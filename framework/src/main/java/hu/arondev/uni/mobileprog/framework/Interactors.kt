package hu.arondev.uni.mobileprog.framework

import hu.arondev.uni.mobileprog.core.interactor.*

data class Interactors (
        val addBookmark: AddBookmark,
        val getBookmarks: GetBookmarks,
        val removeBookmark: RemoveBookmark,
        val addDocument: AddDocument,
        val getDocuments: GetDocuments,
        val removeDocument: RemoveDocument,
        val getOpenDocument: GetOpenDocument,
        val setOpenDocument: SetOpenDocument)