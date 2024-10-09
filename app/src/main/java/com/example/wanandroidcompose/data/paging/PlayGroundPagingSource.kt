package com.example.wanandroidcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wanandroidcompose.data.entity.resp.HomeArticleResp
import com.example.wanandroidcompose.data.entity.resp.UserArticleResp
import com.example.wanandroidcompose.data.repository.HomeRepository
import com.example.wanandroidcompose.data.repository.PlaygroundRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class PlayGroundPagingSource(val repo: PlaygroundRepository) : PagingSource<Int, UserArticleResp.Data>() {
    private val startIndex = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserArticleResp.Data> {
        return try {
            val currentPage = params.key ?: startIndex
            val resp = repo.getUserArticleList(currentPage).map { it.data }.first()
            val data = resp?.datas!!
            LoadResult.Page(
                data = data,
                prevKey = if (currentPage == startIndex) null else currentPage - 1,
                nextKey = if (data.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserArticleResp.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
