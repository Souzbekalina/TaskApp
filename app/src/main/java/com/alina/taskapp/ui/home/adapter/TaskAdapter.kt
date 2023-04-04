package com.alina.taskapp.ui.home.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alina.taskapp.databinding.ItemTaskBinding
import com.alina.taskapp.model.Task

class TaskAdapter(private val onClick: (Task) -> Unit) : Adapter<TaskAdapter.TaskViewHolder>() {

    private val data: ArrayList<Task> = arrayListOf()
    private var color = true

    fun addTask(task: Task) {
        data.add(0, task)
        notifyItemChanged(0)

    }


    @SuppressLint("NotifyDataSetChanged")
    fun addTask(task: List<Task>) {
        data.clear()
        data.addAll(task)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])


    }

    override fun getItemCount(): Int = data.size


    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesk.text = task.desk

            itemView.setOnLongClickListener {
                onClick(task)
                false


            }
            if (color) {
                binding.itemTask.setBackgroundColor(Color.WHITE)
                binding.tvDesk.setTextColor(Color.BLACK)
                binding.tvTitle.setTextColor(Color.BLACK)
                color = false
            }else{
                binding.itemTask.setBackgroundColor(Color.WHITE)
                binding.tvDesk.setTextColor(Color.BLACK)
                binding.tvTitle.setTextColor(Color.BLACK)
                color = true
            }

        }
    }
}


