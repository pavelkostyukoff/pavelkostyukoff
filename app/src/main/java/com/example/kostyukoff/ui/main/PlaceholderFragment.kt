package com.example.kostyukoff.ui.main

import android.net.Uri
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
import com.example.kostyukoff.R
import com.example.kostyukoff.databinding.FragmentMainBinding
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.ui.latest.LatestState
import com.example.kostyukoff.ui.latest.LatestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null
    private val latestViewModel: LatestViewModel by viewModel()


    private val binding get() = _binding!!
    var textArticle: TextView? = null
    var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
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
        latestViewModel.let {
            it.allLatestPosts.observe(viewLifecycleOwner, Observer { newsList ->
                //prepareRecyclerView(newsList)
                newsList
            })
        }
       /* pageViewModel.text.observe(viewLifecycleOwner, Observer {
            text.text = it
        })*/
   /*     pageViewModel.image.observe(viewLifecycleOwner, Observer {
            image.background = it
        return root*/

        latestViewModel.state.observe(viewLifecycleOwner,{
            when(it) {
                is LatestState.Success -> {
                    renderUiMarkers(it.latests)
                }
            }
        })

        return root
    }
    private fun renderUiMarkers(latest: List<LatestsEntity>) {
        val img = latest.firstOrNull()?.name
        var output =  StringBuilder().append(
            img?.substring(
                0,
                4
            )
        )
            .append("s").append(img?.length?.let {
                img.substring(4, it)
            }).toString()
       if (img?.startsWith("https")!!) {
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
    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
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