package com.iremnurpirincci.odev2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iremnurpirincci.odev2.databinding.ListItemBinding


class FirstPageAdapter(private val list: MutableList<FirstPageAdapter>): RecyclerView.Adapter<FirstPageAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(data: FirstPageDataModel){
            binding.tvTitle.text = data.title
            binding.tvDescription.text = data.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstPageAdapter.ListViewHolder {

        val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])


    }

    override fun getItemCount(): Int =list.size
}