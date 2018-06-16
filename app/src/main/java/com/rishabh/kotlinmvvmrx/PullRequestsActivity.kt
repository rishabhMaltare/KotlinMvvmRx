package com.rishabh.kotlinmvvmrx

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.rishabh.kotlinmvvmrx.databinding.ActivityPullRequestsBinding
import com.rishabh.kotlinmvvmrx.models.Example
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_pull_requests.*

class PullRequestsActivity : AppCompatActivity(), RequestAdapter.Listener {

    val TAG = "PullRequestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_requests)

        val binding: ActivityPullRequestsBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_pull_requests)
        binding.mainVm = MainViewModel()
        binding.mainVm?.user = ObservableField(intent.getStringExtra("repo"))
        binding.mainVm?.fetchRepos(observer)

        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private val observer: Observer<List<Example>>
        get() = object : Observer<List<Example>> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(serverResponse: List<Example>) {
                Log.d(TAG, "onNext: response = " + serverResponse.toString())
                recyclerView.adapter = RequestAdapter(serverResponse, this@PullRequestsActivity)
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: error = " + e.localizedMessage)
            }

            override fun onComplete() {
                Log.d(TAG, "Done!")
            }
        }

    override fun onItemClick(android: Example) {

    }

}
