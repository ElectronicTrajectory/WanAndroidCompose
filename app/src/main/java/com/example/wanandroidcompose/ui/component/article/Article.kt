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
    val contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    val bgC = MaterialTheme.colorScheme.secondaryContainer
    Box(
        modifier = modifier
            .background(bgC, MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Column {
            Row {
                Text(
                    text = article.author,
                    color = contentColor,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = article.time, color = contentColor,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                text = article.title, color = contentColor,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = article.type, color = contentColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}

@Preview
@Composable
private fun ArticlePreview() {
    AppTheme {
        Article(
            Modifier, Article(
                "TaylorSwift",
                "TheMan",
                "2019年8月23日",
                "POP",
                ""
            )
        )
    }
}