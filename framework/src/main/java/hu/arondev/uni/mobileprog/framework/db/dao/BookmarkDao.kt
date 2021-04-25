package hu.arondev.uni.mobileprog.framework.db.dao

import androidx.room.*
import hu.arondev.mobileprog.framework.db.entity.BookmarkEntity
import hu.arondev.uni.mobileprog.core.domain.Document
import hu.arondev.uni.mobileprog.framework.db.entity.DocumentEntity

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmark: BookmarkEntity)

    @Delete
    suspend fun removeBookmark(bookmark: BookmarkEntity)

    @Query("SELECT * FROM bookmark WHERE documentUri = :documentUri")
    suspend fun getBookmarks(documentUri: String): List<BookmarkEntity>
}