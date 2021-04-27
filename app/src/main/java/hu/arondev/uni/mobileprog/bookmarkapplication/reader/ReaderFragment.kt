package hu.arondev.uni.mobileprog.bookmarkapplication.reader

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.arondev.uni.mobileprog.bookmarkapplication.R
import hu.arondev.uni.mobileprog.core.domain.Document

class ReaderFragment : Fragment() {

    companion object {
        fun newInstance(document: Document) = ReaderFragment()
    }

    private lateinit var viewModel: ReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reader_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReaderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}