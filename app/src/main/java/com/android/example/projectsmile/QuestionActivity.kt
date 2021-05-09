package com.android.example.projectsmile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val qNumber = intent.extras?.getInt("question")
        setContentView(R.layout.activity_question)
        Toast.makeText(this, ""+qNumber, Toast.LENGTH_SHORT).show()
    }
}