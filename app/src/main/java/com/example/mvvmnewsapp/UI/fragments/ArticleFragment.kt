package com.example.mvvmnewsapp.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvmnewsapp.R
import com.example.mvvmnewsapp.UI.NewsActivity
import com.example.mvvmnewsapp.UI.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}