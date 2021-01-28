package com.example.kotlin_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SecondImageFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_image, container, false)
        return view
    }
    companion object {
        fun newInstance(): SecondImageFragment {
            val fragment = SecondImageFragment()
            return fragment
        }
    }
}