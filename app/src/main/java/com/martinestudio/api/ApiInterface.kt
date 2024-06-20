package com.martinestudio.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

// @GET("End point of API")
    @GET("products?limit=194")
    fun getProductData():Call<MyData>

}