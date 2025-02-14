package com.example.retrofitsimple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitsimple.databinding.ActivityMainBinding
import org.depinfo.retrofit_demo.http.RetrofitUtil
import org.depinfo.retrofit_demo.http.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())

        binding.btn.setOnClickListener({
            val service: Service = RetrofitUtil.get()
            val call: Call<Int> = service.listReposString(5)
            call.enqueue(object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful) {
                        // http 200 http tout s'est bien passé
                        val resultat = response.body()
                        binding.tv.text = resultat.toString()
                    } else {
                        // cas d'erreur http 400 404 etc.
                        binding.tv.text = "REPONSE ERREUR : " + response.code()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    // erreur accès réseau ou alors GSON
                    binding.tv.text = "PAS DE REPONSE : " + t.message
                }
            })
        })
    }
}