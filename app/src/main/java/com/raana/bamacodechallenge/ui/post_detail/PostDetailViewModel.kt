package com.raana.bamacodechallenge.ui.post_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raana.bamacodechallenge.domain.repository.post.model.Post
import com.raana.bamacodechallenge.domain.usecase.post.GetPostDetailUseCase
import com.raana.bamacodechallenge.ui.post.PostScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val useCase: GetPostDetailUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<PostDetailScreenState>(PostDetailScreenState.Initial)
    val state = _state.asStateFlow()

    fun getPostDetail(id: Int) {
        PostDetailScreenState.Loading
        viewModelScope.launch {
            useCase.invoke(id).fold(
                onSuccess = { res ->
                    _state.update { PostDetailScreenState.Success(res) }
                },
                onFailure = { throwable ->
                    _state.update { PostDetailScreenState.Error(throwable) }
                }
            )
        }
    }
}

sealed class PostDetailScreenState {
    object Initial : PostDetailScreenState()
    object Loading : PostDetailScreenState()
    class Error(val throwable: Throwable) : PostDetailScreenState()
    class Success(val post: Post) : PostDetailScreenState()
}