package com.route.islamiappc41gsunwed.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import com.google.android.material.carousel.UncontainedCarouselStrategy
import com.route.islamiappc41gsunwed.databinding.FragmentHadethBinding
import com.route.islamiappc41gsunwed.databinding.FragmentQuranBinding
import com.route.islamiappc41gsunwed.home.adapters.HadethAdapter
import com.route.islamiappc41gsunwed.home.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var layoutManager: CarouselLayoutManager
    lateinit var adapter: HadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager =
            CarouselLayoutManager(FullScreenCarouselStrategy(), CarouselLayoutManager.HORIZONTAL)
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        binding.hadethListRecyclerView.layoutManager = layoutManager
        val list = readHadethList()
        val carouselSnapHelper = CarouselSnapHelper()
        carouselSnapHelper.attachToRecyclerView(binding.hadethListRecyclerView)
        adapter = HadethAdapter(list)
        binding.hadethListRecyclerView.adapter = adapter
    }

    private fun readHadethList(): List<Hadeth> {
        val hadethAsString =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethStringList = hadethAsString.trim().split("#")
        return hadethStringList.map {
            val singleHadethSplited = it.trim().split("\n")
            Hadeth(
                title = singleHadethSplited[0],
                description = singleHadethSplited.subList(1, singleHadethSplited.size)
                    .joinToString()
            )
        }
    }
}
