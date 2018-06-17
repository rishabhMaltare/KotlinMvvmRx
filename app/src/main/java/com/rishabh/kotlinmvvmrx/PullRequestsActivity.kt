package com.rishabh.kotlinmvvmrx

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.rishabh.kotlinmvvmrx.databinding.ActivityPullRequestsBinding
import com.rishabh.kotlinmvvmrx.models.Example
import kotlinx.android.synthetic.main.activity_pull_requests.*


class PullRequestsActivity : AppCompatActivity(), RequestAdapter.Listener, Listener {

    val TAG = "PullRequestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_requests)

        val repo = intent.getStringExtra("repo")

        val binding: ActivityPullRequestsBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_pull_requests)
        binding.mainVm = MainViewModel(this)
        binding.mainVm?.repo = ObservableField(repo)
        binding.mainVm?.fetchRepos()

        val ab = supportActionBar
        ab?.title = repo

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun refreshList(serverResponse: List<Example>) {
        recyclerView.adapter = RequestAdapter(serverResponse, this@PullRequestsActivity)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this@PullRequestsActivity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(example: Example) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(example.htmlUrl))
        startActivity(browserIntent)
    }

}
