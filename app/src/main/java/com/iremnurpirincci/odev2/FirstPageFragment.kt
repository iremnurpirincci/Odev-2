package com.iremnurpirincci.odev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iremnurpirincci.odev2.databinding.FragmentFirstPageBinding


private fun <E> List<E>.add(element: FirstPageDataModel) {

}

class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: FirstPageAdapter
    private var myList = mutableListOf<FirstPageAdapter>()//burası eklendi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstPageBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         //eklenen kısım başı
        myAdapter = FirstPageAdapter(myList)
        binding.recyclerview.adapter =myAdapter
        
        binding.button2.setOnClickListener { 
            val title  =binding.textViewText2.text.toString()
            val description:String = binding.textViewText.text.toString()
            
            if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(context, "Fill all the blanks", Toast.LENGTH_SHORT).show()
        }
            else{
                val newItem = FirstPageDataModel(title, description)
            myList.add(newItem)
            myAdapter.notifyItemInserted(myList.size-1)
            
            binding.textViewText2.setText("")
            binding.textViewText.setText(" ")
        }
        }

//        val myList = listOf(
//            FirstPageDataModel("Read a Book","300 pages"),
//            FirstPageDataModel("Wash the Dishes","wash the dishes"),
//            FirstPageDataModel("Do Homework","Math 2"),
//            FirstPageDataModel("Read a Book","300 pages"),
//            FirstPageDataModel("Read a Book","300 pages")
//        )


        myAdapter = FirstPageAdapter(myList)
        binding.recyclerview.adapter = myAdapter
        binding.button2.setOnClickListener {
            Toast.makeText(context, "Mesaj buraya yazılacak", Toast.LENGTH_SHORT).show()
        }
    }

}