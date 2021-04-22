package hu.arondev.uni.mobileprog.framework.db.dao

import androidx.room.*
import hu.arondev.mobileprog.framework.db.entity.BookmarkEntity

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmark: BookmarkEntity)

    @Delete
    suspend fun removeBookmark(bookmark: BookmarkEntity)

    @Query("SELECT * FROM bookmark WHERE documentUri = :documentUri")
    suspend fun getBookmarks(): List<BookmarkEntity>
}