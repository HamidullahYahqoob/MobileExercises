package com.example.attenteb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.attenteb.adapters.NumberAdapter
import com.example.attenteb.databinding.ActivityMainBinding
import com.example.attenteb.models.Number
import java.lang.Math.random
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NumberAdapter
    var swiperefresh: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()
        fillRecycler()

        swiperefresh = findViewById(R.id.swiperefresh)
        swiperefresh?.setOnRefreshListener {
            mettreAJour()
        }
    }

    private fun mettreAJour() {
        swiperefresh?.isRefreshing = true
        fillRecycler()
        swiperefresh?.isRefreshing = false

    }

    private fun fillRecycler() {
        val items: MutableList<Number> = mutableListOf()
        for (i in 1..100) {
            var chiffre:Int = Random.nextInt(333,445)
            var num : Number = Number(chiffre,i)
            items.add(num)
        }
        adapter.submitList(items)
    }


    private fun setupRecycler() {
        adapter = NumberAdapter()
        binding.rvnumberAdapter.adapter = adapter
        binding.rvnumberAdapter.setHasFixedSize(true)
        binding.rvnumberAdapter.addItemDecoration(
            DividerItemDecoration(
                binding.rvnumberAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }
}