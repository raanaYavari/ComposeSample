package com.raana.composeSample.ui.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raana.composeSample.data.mockData.MockPostData
import com.raana.composeSample.domain.repository.post.model.Post
import com.raana.composeSample.ui.theme.surfaceColor


@Composable
fun PostItem(post: Post, onClick: (Post) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(color = surfaceColor.copy(0.5f), shape = RoundedCornerShape(4.dp))
        .clickable { onClick(post) }) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = post.title,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = post.body,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
@Preview
@Composable
fun PostItemPreview(){
    PostItem(MockPostData.postDetail){

    }
}