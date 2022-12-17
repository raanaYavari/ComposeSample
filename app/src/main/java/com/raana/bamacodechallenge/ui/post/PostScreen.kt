package com.raana.bamacodechallenge.ui.post

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import com.raana.bamacodechallenge.ui.component.AppBottomNavigationBar
import com.raana.bamacodechallenge.ui.component.LoadingAnimation
import com.raana.bamacodechallenge.ui.component.MyTopAppBar
import com.raana.bamacodechallenge.ui.post_detail.PostDetailScreenState
import com.raana.bamacodechallenge.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PostScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope,
    viewModel: PostViewModel,
    navigateToDetail: (Int) -> Unit
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
            when (state) {
                is PostScreenState.Success -> {
                    val currentState = state as PostScreenState.Success
                    LazyColumn {
                        itemsIndexed(currentState.posts) { index, post ->
                            PostItem(post) {
                                navigateToDetail(post.id)
                            }
                        }
                    }
                }
                is PostScreenState.Error -> {

                }
                PostScreenState.Initial -> {

                }
                PostScreenState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        LoadingAnimation()
                    }
                }
            }
        }
    }
}

@Composable
fun PostItem(post: Post, onClick: (Post) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .background(color = surfaceColor, shape = RoundedCornerShape(4.dp))
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