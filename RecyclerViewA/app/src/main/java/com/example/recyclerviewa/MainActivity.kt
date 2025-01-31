 package com.example.recyclerviewa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recyclerviewa.adapters.SecretAdapter
import com.example.recyclerviewa.databinding.ActivityMainBinding
import com.example.recyclerviewa.models.Secret
import java.time.LocalDateTime

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
     private lateinit var adapter: SecretAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()
        fillRecycler()


    }

     private fun fillRecycler() {
         val items: MutableList<Secret> = mutableListOf()
         for (i in 1..1000) {

             items.add(Secret("Nom $i", LocalDateTime.now() , i))
         }
         adapter.submitList(items) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur

     }

     private fun setupRecycler() {
         adapter = SecretAdapter()
         binding.rvSecretAdapter.adapter = adapter
         binding.rvSecretAdapter.setHasFixedSize(true)
         binding.rvSecretAdapter.addItemDecoration(
             DividerItemDecoration(
                 binding.rvSecretAdapter.context, DividerItemDecoration.VERTICAL
             )
         )
     }
 }