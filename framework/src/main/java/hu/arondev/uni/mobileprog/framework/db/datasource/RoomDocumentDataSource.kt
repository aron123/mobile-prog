package hu.arondev.uni.mobileprog.framework.db.datasource

import hu.arondev.uni.mobileprog.core.data.DocumentDataSource
import hu.arondev.uni.mobileprog.core.domain.Document
import hu.arondev.uni.mobileprog.framework.db.BookmarkDatabase
import hu.arondev.uni.mobileprog.framework.db.entity.DocumentEntity

// android.content.context

class RoomDocumentDataSource(val context: Context): DocumentDataSource {

    private val documentDao = BookmarkDatabase.getInstance(context).documentDao()

    override suspend fun add(document: Document) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Document> = documentDao.getDocuments().map{
        Document(
            it.uri,
            it.title,
            it.size,
            it.thumbnailUri
        )
    }

    override suspend fun remove(document: Document) = documentDao.removeDocument(
        DocumentEntity(document.url, document.name, document.size, document.thumbnail)
    )


}