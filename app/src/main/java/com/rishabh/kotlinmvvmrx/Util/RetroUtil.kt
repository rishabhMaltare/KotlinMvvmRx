package com.rishabh.kotlinmvvmrx.Util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Rishabh on 16-06-2018.
 */
object RetroUtil {

    private var retrofit: Retrofit? = null
    private var httpClient: OkHttpClient? = null

    internal fun <T> getRetroService(className: Class<T>): T? {
        return getRetrofit()?.create(className)
    }

    internal fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            val BASE_URL = "https://api.github.com/"
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build()
        }
        return retrofit
    }

    private fun getHttpClient(): OkHttpClient? {
        if (httpClient == null) {
            httpClient = OkHttpClient.Builder().build()
        }
        return httpClient
    }


}
