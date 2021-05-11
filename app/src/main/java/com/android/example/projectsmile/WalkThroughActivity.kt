package com.android.example.projectsmile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.example.projectsmile.databinding.ActivityWalkThroughBinding

class WalkThroughActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWalkThroughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonGotIt.setOnClickListener {

                val sharedPreferences = getSharedPreferences("prefWalk", MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("walkKey", true).apply()
                Toast.makeText(this, "Good luck!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
        }
    }
}