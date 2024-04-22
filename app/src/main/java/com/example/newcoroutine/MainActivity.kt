package com.example.newcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.newcoroutine.adapter.PostAdapter
import com.example.newcoroutine.databinding.ActivityMainBinding
import com.example.newcoroutine.model.Post
import com.example.newcoroutine.repository.PostRepository
import com.example.newcoroutine.viewmodel.PostViewModel
import com.example.newcoroutine.viewmodel.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postAdapter = PostAdapter(this, ArrayList())
        binding.recycler.adapter = postAdapter

        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this) {
            postAdapter.setData(it as ArrayList<Post>)
            binding.progressBar.visibility = View.GONE
            binding.recycler.visibility = View.VISIBLE
        }
    }

}