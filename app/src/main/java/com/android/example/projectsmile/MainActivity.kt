package com.android.example.projectsmile

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.android.example.projectsmile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListeners()
    }

    private fun checkAnsweredQuestions() {
        val sharedPreferences = getSharedPreferences("prefQues", MODE_PRIVATE)
        var arr = IntArray(9)
        var isAllAnswered = true
        for (i in 1..9){
            val key = "key$i"
            val isAnswered = sharedPreferences!!.getBoolean(key,false)
            isAllAnswered = isAllAnswered && isAnswered
            if(isAnswered){
                when(i){
                    1 -> visibilityGone(binding.fragment1.linearLayout, binding.fragment1.textView7, binding.fragment1.button2, binding.fragment1.imageView10, R.drawable.cake)
                    2 -> visibilityGone(binding.fragment2.linearLayout, binding.fragment2.textView7, binding.fragment2.button2, binding.fragment2.imageView10, R.drawable.cake)
                    3 -> visibilityGone(binding.fragment3.linearLayout, binding.fragment3.textView7, binding.fragment3.button2, binding.fragment3.imageView10, R.drawable.cake)
                    4 -> visibilityGone(binding.fragment4.linearLayout, binding.fragment4.textView7, binding.fragment4.button2, binding.fragment4.imageView10, R.drawable.cake)
                    5 -> visibilityGone(binding.fragment5.linearLayout, binding.fragment5.textView7, binding.fragment5.button2, binding.fragment5.imageView10, R.drawable.cake)
                    6 -> visibilityGone(binding.fragment6.linearLayout, binding.fragment6.textView7, binding.fragment6.button2, binding.fragment6.imageView10, R.drawable.cake)
                    7 -> visibilityGone(binding.fragment7.linearLayout, binding.fragment7.textView7, binding.fragment7.button2, binding.fragment7.imageView10, R.drawable.cake)
                    8 -> visibilityGone(binding.fragment8.linearLayout, binding.fragment8.textView7, binding.fragment8.button2, binding.fragment8.imageView10, R.drawable.cake)
                    9 -> visibilityGone(binding.fragment9.linearLayout, binding.fragment9.textView7, binding.fragment9.button2, binding.fragment9.imageView10, R.drawable.cake)
                }
            }
        }
        if (isAllAnswered) {
            binding.giftButton.isEnabled = true
            binding.giftButton.setOnClickListener { startActivity(Intent(this, GiftActivity::class.java)) }
        }
    }

    private fun visibilityGone(linearLayout: LinearLayout, textView: TextView, button: Button, imageView: ImageView, imageRes: Int) {
        linearLayout.visibility = View.GONE
        textView.visibility = View.GONE
        button.visibility = View.GONE
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(imageRes)
    }

    private fun addListeners() {
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

    override fun onResume() {
        super.onResume()
        checkAnsweredQuestions()
    }
}