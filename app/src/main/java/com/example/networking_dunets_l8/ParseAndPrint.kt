package com.example.networking_dunets_l8

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun main(){
    val baseUrl = "https://cat-fact.herokuapp.com"

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(FactServices::class.java)
    val call = service.getFactsList()

    call.enqueue(object : Callback<List<CatFact>> {

        override fun onResponse(call: Call<List<CatFact>>, response: Response<List<CatFact>>) {

            if (response.code() == 200) {

                val factsList = response.body()!!
                for((index, fact) in factsList.withIndex()){
                    println("${index+1}. ${fact.text}")
                }
            }
        }

        override fun onFailure(call: Call<List<CatFact>>, t: Throwable) {}

    })
}

interface FactServices {
    @GET("/facts")
    fun getFactsList(): Call<List<CatFact>>
}

data class CatFact(
        val text: String,
        val createdAt: String,
        val deleted: Boolean,
        val source: String,
        val status: FactStatus,
        val type: String,
        val updatedAt: String,
        val used: Boolean,
        val user: String
)

data class FactStatus(
        val feedback: String,
        val sentCount: Int,
        val verified: Boolean
)
