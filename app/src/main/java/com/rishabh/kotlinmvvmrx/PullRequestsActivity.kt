package com.rishabh.kotlinmvvmrx

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rishabh.kotlinmvvmrx.databinding.ActivityPullRequestsBinding
import com.rishabh.kotlinmvvmrx.models.Example
import kotlinx.android.synthetic.main.activity_pull_requests.*

class PullRequestsActivity : AppCompatActivity(), RequestAdapter.Listener, Listener {

    val TAG = "PullRequestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_requests)

        val binding: ActivityPullRequestsBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_pull_requests)

        binding.mainVm = MainViewModel(this)
        binding.mainVm?.repo = ObservableField(intent.getStringExtra("repo"))
        binding.mainVm?.fetchRepos()

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun refreshList(serverResponse: List<Example>) {
        recyclerView.adapter = RequestAdapter(serverResponse, this@PullRequestsActivity)
    }

    override fun onItemClick(android: Example) {
    }


}
