package hu.arondev.uni.mobileprog.bookmarkapplication.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.arondev.uni.mobileprog.framework.Interactors
import java.lang.IllegalStateException

object BookmarkViewModelFactory: ViewModelProvider.Factory {
    lateinit var application: Application
    lateinit var dependencies: Interactors

    fun inject(application: Application, dependencies: Interactors) {
        BookmarkViewModelFactory.application = application
        BookmarkViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (BookmarkViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Interactors::class.java).newInstance(application, dependencies)
        } else {
            throw IllegalStateException("ViewModel must extend BookmarkViewModel")
        }
    }
}