package com.rishabh.kotlinmvvmrx

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rishabh.kotlinmvvmrx.models.Example

/**
 * Created by Rishabh on 17-06-2018.
 */

class RequestAdapter(private val dataList: List<Example>, private val listener: Listener) :
        RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(android: Example)
    }

    private val colors: Array<String> = arrayOf("#FFFDE7", "#FFF9C4", "#FFF590", "#FFF176", "#FFEE58",
            "#FFEB3B", "#FDD835", "#FBC02D", "#F9A825")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.request_item, parent, false)

        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(example: Example, listener: Listener, colors: Array<String>, position: Int) {

            binding.setVariable(BR.example, example)
            binding.executePendingBindings()

            itemView.setBackgroundColor(android.graphics.Color.parseColor(colors[position % 9]))
            itemView.setOnClickListener { listener.onItemClick(example) }

        }
    }
}