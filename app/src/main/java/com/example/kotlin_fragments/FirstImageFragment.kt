package com.example.kotlin_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirstImageFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first_image, container, false)
        return view
    }


    companion object {
        fun newInstance(): FirstImageFragment {
            val fragment = FirstImageFragment()
            return fragment
        }
    }
}