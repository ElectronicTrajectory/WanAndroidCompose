package com.example.wanandroidcompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wanandroidcompose.data.entity.resp.CollectArticleResp
import com.example.wanandroidcompose.data.repository.OtherRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class CollectedArticlePagingSource(val repo: OtherRepository) : PagingSource<Int, CollectArticleResp.Data>() {
    private val startIndex = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CollectArticleResp.Data> {
        return try {
            val currentPage = params.key ?: startIndex
            val resp = repo.getArticleList(currentPage).map { it.data }.first()
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

    override fun getRefreshKey(state: PagingState<Int, CollectArticleResp.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
