package com.example.newcoroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newcoroutine.databinding.EachRowBinding
import com.example.newcoroutine.model.Post


class PostAdapter(val context:Context, var array: ArrayList<Post>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(var binding: EachRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itembinding  = EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(itembinding)
    }



    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post = array[position]
        holder.binding.id.text = post.id.toString()
        holder.binding.title.text = post.title
    }
    override fun getItemCount(): Int {
        return array.size
    }

    fun setData(postList:ArrayList<Post>){
        this.array = postList
        notifyDataSetChanged()
    }
}