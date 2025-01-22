package com.example.tiroir

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiroir.databinding.ActivityMainBinding
import com.example.tiroir.databinding.NavHeaderBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDrawer()


        title = "Bienvenue à l'activité 1"
    }

    private fun setupDrawer() {
        setupDrawerApplicationBar()
        setupDrawerItemSelected()
        setupDrawerHeader()

    }

    private fun setupDrawerHeader() {
        val headerBinding: NavHeaderBinding = NavHeaderBinding.bind(binding.nvTiroir.getHeaderView(0))

    }

    private fun setupDrawerItemSelected() {
        binding.nvTiroir.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Activity1 -> {
                    val monIntent = Intent(this, MainActivity::class.java)
                    startActivity(monIntent)
                }
                R.id.Activity2 -> {
                    val monIntent = Intent(this, MainActivity2::class.java)
                    startActivity(monIntent)
                }
                R.id.Activity3 -> {
                    val monIntent = Intent(this, MainActivity3::class.java)
                    startActivity(monIntent)
                }
            }
            false
        }
    }

    private fun setupDrawerApplicationBar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.dlTiroir, R.string.ouvert, R.string.ferme)
        binding.dlTiroir.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
        super.onConfigurationChanged(newConfig)
    }
}