package com.alina.taskapp.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alina.taskapp.databinding.ItemOnboardingBinding
import com.alina.taskapp.model.OnBoard
import com.alina.taskapp.utils.loadImage

class OnBoardingAdapter (private val onClick:()->Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

   private val  data= arrayListOf<OnBoard>(
       OnBoard("https://avatars.mds.yandex.net/i?id=04c9e6623ae817fe06b8b739e682bb3e-4233836-images-thumbs&n=13","Fresh food","Task manager Description"),
       OnBoard("https://cdn4.iconfinder.com/data/icons/education-8-2/66/374-1024.png","Fast Delivery","Task manager Description"),
       OnBoard("https://nasha-lestnica.ru/img/info-2.png","Easy Payment","Task manager Description")
   )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),
           parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
      holder.bind(data[position])
    }

    override fun getItemCount(): Int =data.size
    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding):ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
           binding.tvTitle.text=onBoard.title
           binding.tvDesk.text=onBoard.desk
            binding.imgView.loadImage(onBoard.image)
            binding.tvSkip.isVisible=adapterPosition!=2
            binding.btnStart.isVisible=adapterPosition==2
            binding.btnNext.isVisible=adapterPosition!=2
            binding.tvSkip.setOnClickListener{
                onClick()
            }
            binding.btnStart.setOnClickListener{
                onClick()
            }
        }
    }
}