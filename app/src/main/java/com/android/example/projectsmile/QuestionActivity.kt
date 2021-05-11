package com.android.example.projectsmile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.example.projectsmile.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val qNumber = intent.extras?.getInt("question")

        val ansRight = setQuesAndReturnAns(qNumber!!, binding)


        binding.buttonCancel.setOnClickListener { onBackPressed() }
        binding.buttonSubmit.setOnClickListener {
            val ans = binding.ansET.text.toString().trim()
            if (ans.isEmpty())
                Toast.makeText(this, "Answer the question", Toast.LENGTH_SHORT).show()
            else {
                if (ans == ansRight) {
                    Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
                    getSharedPreferences("prefQues", MODE_PRIVATE).edit().putBoolean("key$qNumber", true).apply()
                    onBackPressed()
                } else Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setQuesAndReturnAns(qNumber: Int, binding: ActivityQuestionBinding): String {
        when(qNumber){
            1 -> {binding.quesTv.text = resources.getString(R.string.ques_1)
            return resources.getString(R.string.ans_1)}

            2 -> {binding.quesTv.text = resources.getString(R.string.ques_2)
                return resources.getString(R.string.ans_2)}

            3 -> {binding.quesTv.text = resources.getString(R.string.ques_3)
                return resources.getString(R.string.ans_3)}

            4 -> {binding.quesTv.text = resources.getString(R.string.ques_4)
                return resources.getString(R.string.ans_4)}

            5 -> {binding.quesTv.text = resources.getString(R.string.ques_5)
                return resources.getString(R.string.ans_5)}

            6 -> {binding.quesTv.text = resources.getString(R.string.ques_6)
                return resources.getString(R.string.ans_6)}

            7 -> {binding.quesTv.text = resources.getString(R.string.ques_7)
                return resources.getString(R.string.ans_7)}

            8 -> {binding.quesTv.text = resources.getString(R.string.ques_8)
                return resources.getString(R.string.ans_8)}

            9 -> {binding.quesTv.text = resources.getString(R.string.ques_9)
                return resources.getString(R.string.ans_9)}

            else -> return ""
        }
    }
}