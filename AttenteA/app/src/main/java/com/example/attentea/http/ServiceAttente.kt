package com.example.attentea.http

import retrofit2.Call
import retrofit2.http.GET

interface ServiceAttente {
    @GET("exos/waitaminute")
    fun waitAMinute(): Call<String>
}