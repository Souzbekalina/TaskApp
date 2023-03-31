package com.alina.taskapp.ui.task

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alina.taskapp.App

import com.alina.taskapp.databinding.FragmentTaskBinding
import com.alina.taskapp.model.Task


class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
        val data=
            Task(title = binding.etTitle.text.toString(), desk = binding.etDesk.text.toString())
            App.db.taskDao().insert(data)
            findNavController().navigateUp()
        }

    }
    companion object{
        const val TASK_REQUEST="task"
        const val TASK_KEY="task_key"
    }

}