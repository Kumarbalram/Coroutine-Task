package com.example.newcoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.newcoroutine.repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository):Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}