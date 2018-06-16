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

//class RequestAdapter(private var items: List<Example>, private var listener: OnItemClickListener)
//    : RecyclerView.Adapter<RequestAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        val layoutInflater = LayoutInflater.from(parent?.context)
//        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)
//
//    override fun getItemCount(): Int = items.size
//
//    interface OnItemClickListener {
//        fun onItemClick(position: Int)
//    }
//
//    class ViewHolder(private var binding: RvItemRepositoryBinding) :
//            RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(repo: Repository, listener: OnItemClickListener?) {
//            binding.repository = repo
//            if (listener != null) {
//                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
//            }
//
//            binding.executePendingBindings()
//        }
//    }
//
//}


class RequestAdapter(private val dataList: List<Example>, private val listener: Listener) :
        RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    interface Listener {
        fun onItemClick(android: Example)
    }

    private val colors: Array<String> = arrayOf("#FFFDE7", "#FFF9C4", "#FFF590", "#FFF176", "#FFEE58",
            "#FFEB3B", "#FDD835", "#FBC02D", "#F9A825", "#F57F17")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_row, parent, false)

        return ViewHolder(binding)
    }

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(example: Example, listener: Listener, colors: Array<String>, position: Int) {

            binding.setVariable(BR.example, example)
            binding.executePendingBindings()


            //  itemView.tv_name.text = example.title
            //  itemView.tv_version.text = android.version
            //  itemView.tv_api_level.text = android.apiLevel
            itemView.setBackgroundColor(android.graphics.Color.parseColor(colors[position % 10]))

            itemView.setOnClickListener { listener.onItemClick(example) }
        }
    }
}