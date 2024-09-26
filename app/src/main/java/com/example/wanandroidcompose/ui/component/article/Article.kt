package com.example.wanandroidcompose.ui.component.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wanandroidcompose.data.model.Article

import com.example.wanandroidcompose.ui.theme.AppTheme

@Composable
fun Article(modifier: Modifier, article: Article) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer, MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Column {
            Row {
                Text(
                    text = article.author,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.weight(1F))

                Text(
                    text = article.time,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Text(
                text = article.title,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Text(
                text = article.type,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

    }
}

@Preview
@Composable
private fun ArticlePreview() {
    AppTheme {
        Article(Modifier, Article("123", "123", "123", "123"))
    }
}