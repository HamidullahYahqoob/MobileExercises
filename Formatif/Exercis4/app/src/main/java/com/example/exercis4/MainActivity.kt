package com.example.exercis4

import ObjetAdapter
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.exercis4.databinding.ActivityMainBinding
import com.example.exercis4.models.Objet
import com.example.exercis4.http.RetrofitUtil
import org.depinfo.retrofit_demo.http.Service
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ObjetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        setupRecycler()

        // appeler un service de liste et afficher dans le textview
        binding.btn.setOnClickListener({
            val service: Service = RetrofitUtil.get()
            val num: String = binding.et.text.toString()
            val converti : Int = num.toInt()
            val call: Call<List<Objet>> = service.listReposString(converti)
            call.enqueue(object : Callback<List<Objet>> {
                override fun onResponse(call: Call<List<Objet>>, response: Response<List<Objet>>) {
                    if (response.isSuccessful) {
                        // http 200 http tout s'est bien passé
                        val resultat = response.body()
                        if(resultat != null){
                            adapter.submitList(resultat)
                        }

                    } else {
                        // cas d'erreur http 400 404 etc.
                        binding.tv.text = "REPONSE ERREUR : " + response.code()
                    }
                }

                override fun onFailure(call: Call<List<Objet>>, t: Throwable) {
                    // erreur accès réseau ou alors GSON
                    binding.tv.text = "PAS DE REPONSE : " + t.message
                }
            })
        })
    }

    private fun setupRecycler() {
        adapter = ObjetAdapter() // Créer l'adapteur
        binding.rvPersonneAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
        binding.rvPersonneAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvPersonneAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvPersonneAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }
}
