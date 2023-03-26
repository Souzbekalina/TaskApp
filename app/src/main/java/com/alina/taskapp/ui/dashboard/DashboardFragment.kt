package com.alina.taskapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alina.taskapp.data.local.Pref
import com.alina.taskapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var pref:Pref

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
        binding.edAny.setText(pref.getAnyText())
        binding.btnSave.setOnClickListener {
            pref.saveAnyText(binding.edAny.text.toString())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}