package com.iremnurpirincci.odev2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.navigation.Navigation
import com.iremnurpirincci.odev2.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        binding.nextbutton1.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_homePageFragment_to_firstPageFragment)
        }


        return binding.root
    }

}