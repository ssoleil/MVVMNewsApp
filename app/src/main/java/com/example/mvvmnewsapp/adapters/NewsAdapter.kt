package com.example.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.R
import kotlinx.android.synthetic.main.item_article.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsAdapterHolder>() {

    inner class NewsAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterHolder {
        return NewsAdapterHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsAdapterHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(ivArticle)
            tvArticleSource.text = article.source.name
            tvArticleTitle.text = article.title
            tvArticlePublishedAt.text = article.publishedAt
            tvArticleDescription.text = article.description
            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}