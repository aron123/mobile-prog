package hu.arondev.uni.mobileprog.bookmarkapplication

import hu.arondev.uni.mobileprog.core.domain.Document

interface MainActivityDelegate {
    fun openDocument(document: Document)
}