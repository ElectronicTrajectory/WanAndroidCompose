package com.example.wanandroidcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
import com.example.wanandroidcompose.data.repository.HomeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class MyPagingSource(val repo: HomeRepository) : PagingSource<Int, HomeArticleResp.Data>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeArticleResp.Data> {
        return try {
            val currentPage = params.key ?: 1
            val resp = repo.getArticleList(currentPage).map { it.data }.first()
            val data = resp?.datas!!
            LoadResult.Page(
                data = data,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (data.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HomeArticleResp.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
