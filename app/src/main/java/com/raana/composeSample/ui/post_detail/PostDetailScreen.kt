package com.raana.composeSample.ui.post_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.raana.composeSample.R
import com.raana.composeSample.ui.component.LoadingAnimation
import com.raana.composeSample.ui.component.MyTopAppBar
import com.raana.composeSample.ui.component.NetworkFailure
import com.raana.composeSample.ui.post.PostItem

@Composable
fun PostDetailScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: PostDetailViewModel,
    postId: Int,
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getPostDetail(postId)
    }
    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(stringResource(id = R.string.post_detail))
    }) {
        when (state) {
            is PostDetailScreenState.Error -> {
                val currentState = state as PostDetailScreenState.Error
                NetworkFailure(Modifier.fillMaxSize(), currentState.throwable.message) {
                    viewModel.getPostDetail(postId)
                }
            }
            PostDetailScreenState.Initial -> {}
            PostDetailScreenState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    LoadingAnimation()
                }
            }
            is PostDetailScreenState.Success -> {
                val currentState = state as PostDetailScreenState.Success
                PostItem(post = currentState.post) {

                }
            }
        }
    }

}