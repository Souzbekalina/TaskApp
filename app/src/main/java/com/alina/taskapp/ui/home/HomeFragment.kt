package com.alina.taskapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alina.taskapp.App
import com.alina.taskapp.R
import com.alina.taskapp.databinding.FragmentHomeBinding
import com.alina.taskapp.model.Task
import com.alina.taskapp.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter = TaskAdapter(this::deleteClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        binding.rvView.adapter = adapter
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)


        }


    }

    private fun setData() {
        val data = App.db.taskDao().getAll()
        adapter.addTask(data)
    }

    private fun deleteClick(task: Task) {
        val alertdialog = AlertDialog.Builder(requireContext())
        alertdialog.setTitle("Deleted?")

        alertdialog.setNegativeButton("No") { dialog, pos ->
            dialog?.cancel()
        }
        alertdialog.setPositiveButton("Yes") { dialog, pos ->
            App.db.taskDao().delete(task)
            setData()
        }
        alertdialog.show().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}