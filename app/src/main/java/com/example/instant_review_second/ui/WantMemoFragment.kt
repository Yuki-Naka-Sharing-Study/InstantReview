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

class WantMemoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_want_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.tool_bar_want_memo)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        val fab = getActivity()?.findViewById<FloatingActionButton>(R.id.floating_action_button)

        val btnCloseWantMemo: ImageButton = view.findViewById(R.id.btn_close_want_memo)
        btnCloseWantMemo.setOnClickListener {
            // MainActivityに戻りたい
            if (fab != null) {
                fab.visibility = View.VISIBLE
            }
            fragmentManager
                ?.popBackStack()
        }
        val textViewSaveWantMemo: TextView = view.findViewById(R.id.text_view_save_want_memo)
        textViewSaveWantMemo.setOnClickListener {
            val mainActivity = activity as MainActivity?
            if (mainActivity != null) {
                lifecycleScope.launch(Dispatchers.IO){
                    withContext(Dispatchers.Default) {
                        mainActivity.reviewDao.insertAll()
                    }
                }
            }
        }
    }

}