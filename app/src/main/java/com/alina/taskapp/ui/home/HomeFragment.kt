package com.alina.taskapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alina.taskapp.R
import com.alina.taskapp.databinding.FragmentHomeBinding
import com.alina.taskapp.model.Task
import com.alina.taskapp.ui.home.adapter.TaskAdapter
import com.alina.taskapp.ui.task.TaskFragment.Companion.TASK_KEY
import com.alina.taskapp.ui.task.TaskFragment.Companion.TASK_REQUEST

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private  val adapter= TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      setFragmentResultListener(TASK_REQUEST){ key, bundle->
          val result=bundle.getSerializable(TASK_KEY) as Task
          Log.e("ololo","onViewcreated " + result)
          adapter.addTask(result)
      }
        binding.rvView.adapter=adapter
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}