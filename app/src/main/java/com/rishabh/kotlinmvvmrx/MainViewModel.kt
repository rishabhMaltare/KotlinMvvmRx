package com.rishabh.kotlinmvvmrx

import android.databinding.ObservableField
import com.rishabh.kotlinmvvmrx.Util.RetroUtil
import com.rishabh.kotlinmvvmrx.models.Example
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Rishabh on 16-06-2018.
 */


class MainViewModel {

    val TAG = "MainViewModel"

    var user = ObservableField("")

    fun fetchRepos(observer: Observer<List<Example>>) {

        val callRx = RetroUtil.getRetroService<IntroFitRx>(IntroFitRx::class.java)?.getRepos(user.get()
                .toString(), "open")

        callRx?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(observer)
    }

//    private val observer: Observer<List<Example>>
//        get() = object : Observer<List<Example>> {
//            override fun onSubscribe(d: Disposable) {}
//
//            override fun onNext(serverResponse: List<Example>) {
//                Log.d(TAG, "onNext: response = " + serverResponse.toString())
//                startListActivity(serverResponse)
//            }
//
//            override fun onError(e: Throwable) {
//                Log.e(TAG, "onError: error = " + e.localizedMessage)
//            }
//
//            override fun onComplete() {
//                Log.d(TAG, "Done!")
//            }
//        }

    private fun startListActivity(serverResponse: List<Example>) {


    }

    private fun handleResponse(androidList: List<Example>) {

//        mAndroidArrayList = ArrayList(androidList)
//        mAdapter = DataAdapter(mAndroidArrayList!!, this)
//
//        rv_android_list.adapter = mAdapter
    }

    private fun handleError(error: Throwable) {
//        Log.d(TAG, error.localizedMessage)
//        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

}




