package hu.arondev.uni.mobileprog.framework.db
import androidx.room.Database
import androidx.room.RoomDatabase
import hu.arondev.mobileprog.framework.db.entity.BookmarkEntity
import hu.arondev.uni.mobileprog.framework.db.dao.BookmarkDao
import hu.arondev.uni.mobileprog.framework.db.dao.DocumentDao
import hu.arondev.uni.mobileprog.framework.db.entity.DocumentEntity

@Database(
    entities = [BookmarkEntity::class, DocumentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BookmarkDatabase: RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "bookmark.db"
        private var instance: BookmarkDatabase? = null

        private fun create (context: Context): BookmarkDatabase =
            Room.databaseBuilder(context, BookmarkDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        fun getInstance(context: Context): BookmarkDatabase = (instance ? create{context}.also{instance = it})

        abstract fun bookmarkDao(): BookmarkDao
        abstract fun documentDao(): DocumentDao
    }
}