package com.example.attentea

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.attentea.databinding.ActivityMainBinding
import com.example.attentea.http.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startDownload()
                RetrofitUtil.get().waitAMinute().enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        endDownload()
                        Toast.makeText(getApplicationContext(), "Cela fonctionne!", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        endDownload()
                        Toast.makeText(getApplicationContext(), "Ouch bouton", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }

        })

    }

    private fun startDownload() {
        binding.progress.visibility = View.VISIBLE
        binding.stuff.visibility = View.GONE
    }

    private fun endDownload() {
        binding.progress.visibility = View.GONE //INVISIBLE occupe de l'espace GONE non
        binding.stuff.visibility = View.VISIBLE
    }
}