package com.raana.bamacodechallenge.ui.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import com.raana.bamacodechallenge.ui.component.MyTopAppBar
import com.raana.bamacodechallenge.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PostScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope,
    viewModel: PostViewModel
) {
    val state by viewModel.state.collectAsState()

    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopAppBar(title = stringResource(id = R.string.post))
    }, snackbarHost = {
        SnackbarHost(hostState = it) {
            Snackbar(
                backgroundColor = red, contentColor = textColor, snackbarData = it
            )
        }
    }) {
        val swipeRefreshState = rememberSwipeRefreshState(false)
        SwipeRefresh(state = swipeRefreshState, onRefresh = {
            viewModel.getPosts()
        }) {
            if (state is PostScreenState.Success) {
                val currentState = state as PostScreenState.Success
                LazyColumn {
                    itemsIndexed(currentState.posts) { index, post ->
                        PostItem(post)
                    }
                }
            }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = surfaceColor, shape = RoundedCornerShape(4.dp))
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = post.title,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = post.body,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}