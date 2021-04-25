package hu.arondev.uni.mobileprog.framework.db.datasource;

import android.content.Context
import hu.arondev.mobileprog.framework.db.entity.BookmarkEntity
import hu.arondev.uni.mobileprog.core.data.BookmarkDataSource
import hu.arondev.uni.mobileprog.core.domain.Bookmark
import hu.arondev.uni.mobileprog.core.domain.Document
import hu.arondev.uni.mobileprog.framework.db.BookmarkDatabase

public class RoomBookmarkDataSource(context: Context): BookmarkDataSource {

    private val bookmarkDao = BookmarkDatabase.getInstance(context).bookmarkDao()

    override suspend fun add(document: Document, bookmark: Bookmark) = bookmarkDao.addBookmark(
            BookmarkEntity(bookmark.id, document.url, bookmark.page)
    )

    override suspend fun read(document: Document): List<Bookmark> = bookmarkDao.getBookmarks(document.url).map {
        Bookmark(it.id, it.page)
    }

    override suspend fun remove(document: Document, bookmark: Bookmark) = bookmarkDao.removeBookmark(
            BookmarkEntity(bookmark.id, document.url, bookmark.page)
    )

}
