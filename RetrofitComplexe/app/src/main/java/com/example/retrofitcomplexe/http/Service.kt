package org.depinfo.retrofit_demo.http

import com.example.retrofitcomplexe.http.Objet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("exos/truc/complexe")
    fun listReposString(@Query("name") nom: String): Call<Objet>


//
//    @GET("exos/{annee}/complexe")
//    fun dsds(@Path("annee") nom: String): Call<Objet>


    // http://982.2312.3123.312/a/b/c/d?id=pouet&fr=fr
}