package org.depinfo.retrofit_demo.http

import com.example.exercis4.models.Objet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("exam/representations/{nombre}")
    fun listReposString(@Path("nombre") nombre: Int): Call<List<Objet>>
}