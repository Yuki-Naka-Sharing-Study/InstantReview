package com.example.instant_review_second

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.instant_review_second.ui.AteFragment
import com.example.instant_review_second.ui.ReviewMakeFragment
import com.example.instant_review_second.ui.WantFragment
import com.example.instant_review_second.ui.WantMemoFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var position: Int = 0
    private lateinit var btnAte: Button
    private lateinit var btnWant: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAte = findViewById(R.id.btn_ate)
        btnWant = findViewById(R.id.btn_want_to_eat)

        btnAte.setOnClickListener {
            position = 0
            supportFragmentManager.beginTransaction()
                .replace(R.id.toggle_container, AteFragment())
                .commit()
        }

        btnWant.setOnClickListener {
            position = 1
            supportFragmentManager.beginTransaction()
                .replace(R.id.toggle_container, WantFragment())
                .commit()
        }

        // FloatingActionButtonの生成
        var floatingActionButton = FloatingActionButton(this)
        floatingActionButton = findViewById(R.id.floating_action_button)
        floatingActionButton.setOnClickListener {
            if (position == 0) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.toggle_container, ReviewMakeFragment())
                    // .addToBackStack(null)の「()」内には戻りたい箇所に相当するタグを書く。
                    // 戻りたい箇所に相当する引数が無い場合は「(null)」でいい。
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.toggle_container, WantMemoFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    //画面がタッチされた時に反応するやつ
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // InputMethodManagerを取得
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //背景のlinearLayoutを取得
        val constraintLayout = findViewById<ConstraintLayout>(R.id.toggle_container)
        // キーボードを閉じる
        inputMethodManager.hideSoftInputFromWindow(
            constraintLayout.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
        return false
    }
}