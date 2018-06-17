package com.rishabh.kotlinmvvmrx

import android.databinding.ObservableField
import android.util.Log
import com.rishabh.kotlinmvvmrx.Util.RetroUtil
import com.rishabh.kotlinmvvmrx.models.Example
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by Rishabh on 16-06-2018.
 */

interface Listener {
    fun refreshList(serverResponse: List<Example>)
}

class MainViewModel(private val listener: Listener?) {

    val TAG = "MainViewModel"

    var repo = ObservableField("")

    private val observer: Observer<List<Example>>
        get() = object : Observer<List<Example>> {

            override fun onSubscribe(d: Disposable) {}

            override fun onNext(serverResponse: List<Example>) {
                Log.d(TAG, "onNext: response = " + serverResponse.toString())
                listener?.refreshList(serverResponse)
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: error = " + e.localizedMessage)
            }

            override fun onComplete() {
                Log.d(TAG, "Done!")
            }
        }


    fun fetchRepos() {

        val callRx = RetroUtil.getRetroService<IntroFitRx>(IntroFitRx::class.java)
                ?.getRepos(repo = repo.get().toString(), state = "open")

        callRx?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(observer)
    }


}




