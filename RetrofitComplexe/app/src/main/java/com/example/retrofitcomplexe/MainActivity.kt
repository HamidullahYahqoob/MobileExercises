package com.example.retrofitcomplexe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitcomplexe.databinding.ActivityMainBinding
import com.example.retrofitcomplexe.http.Objet
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
            RetrofitUtil.get().listReposString("Hamidullah").enqueue(object : Callback<Objet> {
                override fun onResponse(call: Call<Objet>, response: Response<Objet>) {
                    val monObject : Objet? = response.body()
                    if (monObject != null) {
                        binding.tv.text=monObject.b
                    } else {

                    }

                    //binding.tv.text=
                }

                override fun onFailure(call: Call<Objet>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        })
    }
}