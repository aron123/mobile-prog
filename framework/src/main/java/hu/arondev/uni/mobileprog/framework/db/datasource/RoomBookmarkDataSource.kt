package hu.arondev.uni.mobileprog.framework.db.datasource;

import android.content.Context
import hu.arondev.uni.mobileprog.core.data.BookmarkDataSource
import hu.arondev.uni.mobileprog.core.domain.Bookmark
import hu.arondev.uni.mobileprog.core.domain.Document

public class RoomBookmarkDataSource(context: Context): BookmarkDataSource {
    override suspend fun add(document: Document, bookmark: Bookmark) {
        TODO("Not yet implemented")
    }

    override suspend fun read(document: Document): List<Bookmark> {
        TODO("Not yet implemented")
    }

    override suspend fun remove(document: Document, bookmark: Bookmark) {
        TODO("Not yet implemented")
    }

}
