package com.example.kostyukoff.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kostyukoff.databinding.FragmentMainBinding
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.ui.latest.LatestState
import com.example.kostyukoff.ui.latest.LatestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null
    private val latestViewModel: LatestViewModel by viewModel()
    var latests: List<LatestsEntity> = emptyList()

    private val binding get() = _binding!!
    var textArticle: TextView? = null
    var image: ImageView? = null
    var countPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  ViewModelProvider(this).get(LatestViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root
        textArticle = binding.textPost
        image = binding.imagePost
        latestViewModel.text.observe(viewLifecycleOwner, Observer {
            countPage = it
            renderUiData(latests, it)
            //todo перезагрузить страницу ui
        })

        latestViewModel.state.observe(viewLifecycleOwner,{
            when(it) {
                is LatestState.Success -> {
                    latests = it.latests
                    renderUiData(it.latests, countPage)
                }
            }
        })

        return root
    }
    private fun renderUiData(latest: List<LatestsEntity>, count: Int) {
        if (latest.isNotEmpty()) {
        val img = latest.get(count).name
        var output =  StringBuilder().append(
            img.substring(
                0,
                4
            )
        )
            .append("s").append(img?.length?.let {
                img.substring(4, it)
            }).toString()
       if (img.startsWith("https")!!) {
           output = img
       }


        val name = latest.firstOrNull()?.linkGif
        Glide.with(this)
            .asGif()
            .load(output)
            .placeholder(android.R.drawable.ic_media_play)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
            .into(image!!);
        latestViewModel.list = latest
        latest.map {
            textArticle?.text = name
        }
        }
    }
    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}