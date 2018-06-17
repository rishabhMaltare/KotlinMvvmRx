package com.rishabh.kotlinmvvmrx

import com.rishabh.kotlinmvvmrx.models.Example
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Rishabh on 16-06-2018.
 */
interface IntroFitRx {
    @GET("repos/{repo}/pulls")
    fun getRepos(
            @Path(value = "repo", encoded = true) repo: String,
            @Query("state") state: String
    ): Observable<ArrayList<Example>>
}
//https://api.github.com/users/%7Buser%7D/repos?user=android.databinding.ObservableField%40fa9777b
//pulls?state=open