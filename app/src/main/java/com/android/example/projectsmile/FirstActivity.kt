package com.android.example.projectsmile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.example.projectsmile.databinding.ActivityFirstBinding
import java.util.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFirstBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {
            val name = binding.nameET.text.toString()

            if(name.isEmpty())
                Toast.makeText(this, "Enter your name!", Toast.LENGTH_SHORT).show()
            else if (name.trim().toLowerCase(Locale.ROOT) == "moha") {

                Toast.makeText(this, "Yay! the name is correct.", Toast.LENGTH_SHORT).show()
                if(isWalkThroughDone())
                    startActivity(Intent(this, MainActivity::class.java))
                else
                    startActivity(Intent(this, WalkThroughActivity::class.java))
                this.finish()
            }
            else Toast.makeText(this, "Incorrect name!", Toast.LENGTH_SHORT).show()
        }
        setContentView(binding.root)

    }

    private fun isWalkThroughDone(): Boolean {
        val sharedPreferences = getSharedPreferences("prefWalk", MODE_PRIVATE)
        return sharedPreferences.getBoolean("walkKey", false)
    }
}