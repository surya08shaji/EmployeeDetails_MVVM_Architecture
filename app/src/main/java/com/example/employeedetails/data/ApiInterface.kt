package com.example.employeedetails.data

import com.example.employeedetails.model.DataModelItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/5d565297300000680030a986")
    suspend fun getList(): Response<List<DataModelItem>>

    companion object {
        private var apiInterface:ApiInterface? = null
        fun getInstance(): ApiInterface{
            if(apiInterface == null ){


                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()


                val retrofit = Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                apiInterface = retrofit.create(ApiInterface::class.java)
            }
            return apiInterface!!
        }
    }
}