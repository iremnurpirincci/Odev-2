package com.iremnurpirincci.odev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.iremnurpirincci.odev2.databinding.FragmentFirstPageBinding


class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private val list = ArrayList<Item>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPageBinding.inflate(inflater,container,false)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = TodoAdapter(list)
        binding.button2.setOnClickListener {
            addToList()
        }
        return binding.root
    }

    private fun addToList(){
        val title = binding.textViewText2.text.toString()
        val description = binding.textViewText.text.toString()

        if (title.isEmpty() || description.isEmpty()){
            Toast.makeText(context,"Fill all the blanks",Toast.LENGTH_SHORT).show()
        }
        else{
            list.add(Item(title, description))
            binding.recyclerview.adapter?.notifyDataSetChanged()
            binding.textViewText2.text.clear()
            binding.textViewText.text.clear()
        }
    }
}

