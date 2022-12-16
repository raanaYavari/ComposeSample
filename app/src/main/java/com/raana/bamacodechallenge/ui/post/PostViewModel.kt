package com.raana.bamacodechallenge.ui.post

import dagger.hilt.android.lifecycle.HiltViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import com.raana.bamacodechallenge.domain.usecase.post.GetPostsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<PostScreenState>(PostScreenState.Initial)
    val state = _state.asStateFlow()


    init {
      getPosts()
    }

    fun getPosts(){
        _state.update { PostScreenState.Loading }
        viewModelScope.launch {
            getPostsUseCase.invoke().fold(onSuccess = { res ->
                _state.update { PostScreenState.Success(res) }
            },
                onFailure = { throwable ->
                    _state.update { PostScreenState.Error(throwable) }
                })
        }
    }
}

sealed class PostScreenState {
    object Initial : PostScreenState()
    object Loading : PostScreenState()
    class Error(val throwable: Throwable) : PostScreenState()
    class Success(val posts: List<Post>) : PostScreenState()
}