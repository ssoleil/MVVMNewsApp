package com.example.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmnewsapp.model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article) : Long

    @Query("SELECT * from articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete
    suspend fun delete(article: Article)
}