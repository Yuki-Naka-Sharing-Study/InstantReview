package com.example.instant_review_second.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.instant_review_second.MainActivity
import com.example.instant_review_second.R
import org.w3c.dom.Text

class ReviewMakeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_make, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.tool_bar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnClose: ImageButton = view.findViewById(R.id.btn_close)
        btnClose.setOnClickListener {
            // MainActivityに戻りたい
            fragmentManager
                ?.popBackStack()
        }

        val textSave: TextView = view.findViewById(R.id.save_text_view)
        textSave.setOnClickListener {

        }
    }

}