package hu.arondev.uni.mobileprog.framework.db.datasource

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import hu.arondev.uni.mobileprog.core.data.DocumentDataSource
import hu.arondev.uni.mobileprog.core.domain.Document
import hu.arondev.uni.mobileprog.framework.db.BookmarkDatabase
import hu.arondev.uni.mobileprog.framework.db.entity.DocumentEntity
import hu.arondev.uni.mobileprog.framework.util.FileUtil

class RoomDocumentDataSource(val context: Context): DocumentDataSource {

    private val documentDao = BookmarkDatabase.getInstance(context).documentDao()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override suspend fun add(document: Document) {
        val details = FileUtil.getDocumentDetails(context, document.url)
        return documentDao.addDocument(
            DocumentEntity(document.url, details.name, details.size, details.thumbnail)
        )
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