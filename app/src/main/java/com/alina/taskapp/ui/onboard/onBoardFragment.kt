package com.alina.taskapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.alina.taskapp.R
import com.alina.taskapp.data.local.Pref
import com.alina.taskapp.databinding.FragmentOnBoardBinding
import com.alina.taskapp.ui.onboard.adapter.OnBoardingAdapter

class onBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private val adapter = OnBoardingAdapter(this::onStartClick, this::onNextClick)
    private lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onNextClick() {
        binding.viewPager.setCurrentItem(getItem(+1))
    }

    private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + 1

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.viewPager.adapter = adapter

        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver);
    }

    private fun onStartClick() {
        pref.saveSeen()
        findNavController().navigateUp()
    }


}



