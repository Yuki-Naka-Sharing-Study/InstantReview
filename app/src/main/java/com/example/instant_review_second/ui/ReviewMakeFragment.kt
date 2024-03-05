package com.example.instant_review_second.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.instant_review_second.MainActivity
import com.example.instant_review_second.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar_review_make)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        val fab = getActivity()?.findViewById<FloatingActionButton>(R.id.floating_action_button)

        val btnCloseReviewMake: ImageButton = view.findViewById(R.id.btn_close_review_make)
        btnCloseReviewMake.setOnClickListener {
            // MainActivityに戻りたい
            if (fab != null) {
                fab.visibility = View.VISIBLE
            }
            fragmentManager
                ?.popBackStack()
        }

        val textViewSaveReviewMake: TextView = view.findViewById(R.id.text_view_save_review_make)
        textViewSaveReviewMake.setOnClickListener {
            val mainActivity = activity as MainActivity?
            if (mainActivity != null) {
                lifecycleScope.launch(Dispatchers.IO){
                    withContext(Dispatchers.Default) {
                        mainActivity.reviewDao.insertAll()
                        println("insertAll()したよ。")
                    }
                }
            }
        }
    }

}