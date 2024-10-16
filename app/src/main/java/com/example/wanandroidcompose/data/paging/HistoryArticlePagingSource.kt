package com.example.wanandroidcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wanandroidcompose.data.dao.ArticleDao
import com.example.wanandroidcompose.data.dao.ArticleEntity

class HistoryArticlePagingSource(
    private val articleDao: ArticleDao,
    private val pageSize: Int
) : PagingSource<Int, ArticleEntity>() {
    private val startIndex = 1
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleEntity> {
        return try {
            val currentPage = params.key ?: startIndex
            val data = articleDao.getArticlesByPage(pageSize, (currentPage - 1) * pageSize)
            if (data.isEmpty()){
                throw Exception("no data")
            }
            LoadResult.Page(
                data = data,
                prevKey = if (currentPage == startIndex) null else currentPage - 1,
                nextKey = if (data.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
