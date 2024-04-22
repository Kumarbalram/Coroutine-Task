package com.example.newcoroutine.network

import com.example.newcoroutine.model.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getPost():ArrayList<Post>
}