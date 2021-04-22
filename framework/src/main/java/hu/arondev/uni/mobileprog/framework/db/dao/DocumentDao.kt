package hu.arondev.uni.mobileprog.framework.db.dao

import androidx.room.*
import hu.arondev.uni.mobileprog.framework.db.entity.DocumentEntity

@Dao
interface DocumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDocument(document: DocumentEntity)

    @Delete
    suspend fun removeDocument(document: DocumentEntity)

    @Query("SELECT * FROM document")
    suspend fun getDocuments(): List<DocumentEntity>
}