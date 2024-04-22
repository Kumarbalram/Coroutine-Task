package com.example.newcoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newcoroutine.model.Post
import com.example.newcoroutine.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository:PostRepository):ViewModel() {

    val postMutableLiveData:MutableLiveData<ArrayList<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            try {
                val response = postRepository.getPost()
                postMutableLiveData.value = response
            }catch (e:Exception){

            }

        }
    }
}