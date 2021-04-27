package hu.arondev.uni.mobileprog.bookmarkapplication.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import hu.arondev.uni.mobileprog.bookmarkapplication.BookmarkApplication
import hu.arondev.uni.mobileprog.framework.Interactors

class BookmarkViewModel (application: Application, protected val interactors: Interactors): AndroidViewModel(application) {
    protected val bookmarkApplication: BookmarkApplication = getApplication()
}