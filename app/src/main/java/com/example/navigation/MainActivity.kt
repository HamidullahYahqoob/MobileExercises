package com.example.navigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClique.setOnClickListener{
            val int = Intent(this,MainActivity2::class.java)
            if (binding.etMessage.text.toString().trim() == "") {

                startActivity(int)
            } else {
                int.putExtra("Text",binding.etMessage.text.toString())
                startActivity(int)
            }


        }
    }
}