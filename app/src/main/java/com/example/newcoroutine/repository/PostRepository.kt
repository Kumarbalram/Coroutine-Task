package com.example.newcoroutine.repository

import com.example.newcoroutine.model.Post
import com.example.newcoroutine.network.RetrofitBuilder

class PostRepository {

    suspend fun getPost():ArrayList<Post> =  RetrofitBuilder.api.getPost()
}