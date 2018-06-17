package com.rishabh.kotlinmvvmrx

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.rishabh.kotlinmvvmrx.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.mainVm = MainViewModel(null)
    }

    fun startActivity(view: View) {
        val intent = Intent(this, PullRequestsActivity::class.java)
        intent.putExtra("repo", binding?.mainVm?.repo?.get())
        startActivity(intent)
    }

}
