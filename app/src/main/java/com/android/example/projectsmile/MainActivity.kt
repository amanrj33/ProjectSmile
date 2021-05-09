package com.android.example.projectsmile

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.android.example.projectsmile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        addListeners(binding)
        binding.rulesButton.setOnClickListener { startActivity(Intent(this, WalkThroughActivity::class.java)) }
        checkAnsweredQuestions(binding)
        setContentView(binding.root)
    }

    private fun checkAnsweredQuestions(binding: ActivityMainBinding) {
        val sharedPreferences = getSharedPreferences("prefQues", MODE_PRIVATE)
        var arr = IntArray(9)
        for (i in 1..9){
            val key = "key$i"
            if(sharedPreferences!!.getBoolean(key,false)){
                when(i){
                    1 -> visibilityGone(binding.fragment1.linearLayout, binding.fragment1.textView7, binding.fragment1.button2)
                    2 -> visibilityGone(binding.fragment2.linearLayout, binding.fragment2.textView7, binding.fragment2.button2)
                    3 -> visibilityGone(binding.fragment3.linearLayout, binding.fragment3.textView7, binding.fragment3.button2)
                    4 -> visibilityGone(binding.fragment4.linearLayout, binding.fragment4.textView7, binding.fragment4.button2)
                    5 -> visibilityGone(binding.fragment5.linearLayout, binding.fragment5.textView7, binding.fragment5.button2)
                    6 -> visibilityGone(binding.fragment6.linearLayout, binding.fragment6.textView7, binding.fragment6.button2)
                    7 -> visibilityGone(binding.fragment7.linearLayout, binding.fragment7.textView7, binding.fragment7.button2)
                    8 -> visibilityGone(binding.fragment8.linearLayout, binding.fragment8.textView7, binding.fragment8.button2)
                    9 -> visibilityGone(binding.fragment9.linearLayout, binding.fragment9.textView7, binding.fragment9.button2)
                }
            }
        }
    }

    private fun visibilityGone(linearLayout: LinearLayout, textView: TextView, button: Button) {
        linearLayout.visibility = View.GONE
        textView.visibility = View.GONE
        button.visibility = View.GONE
    }

    private fun addListeners(binding: ActivityMainBinding) {
        binding.fragment1.button2.setOnClickListener { callQuestionActivity(1) }
        binding.fragment2.button2.setOnClickListener { callQuestionActivity(2) }
        binding.fragment3.button2.setOnClickListener { callQuestionActivity(3) }
        binding.fragment4.button2.setOnClickListener { callQuestionActivity(4) }
        binding.fragment5.button2.setOnClickListener { callQuestionActivity(5) }
        binding.fragment6.button2.setOnClickListener { callQuestionActivity(6) }
        binding.fragment7.button2.setOnClickListener { callQuestionActivity(7) }
        binding.fragment8.button2.setOnClickListener { callQuestionActivity(8) }
        binding.fragment9.button2.setOnClickListener { callQuestionActivity(9) }
    }

    private fun callQuestionActivity(i: Int) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("question", i)
        startActivity(intent)
    }
}