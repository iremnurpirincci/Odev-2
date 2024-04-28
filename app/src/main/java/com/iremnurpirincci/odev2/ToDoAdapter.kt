package com.iremnurpirincci.odev2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iremnurpirincci.odev2.databinding.ListItemBinding


class TodoAdapter(private val list: ArrayList<Item>): RecyclerView.Adapter<TodoAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(getList: Item){
            binding.tvTitle.text = getList.title
            binding.tvDescription.text = getList.description
            binding.deleteIcon.setOnClickListener {
                list.remove(getList)
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int =list.size
}