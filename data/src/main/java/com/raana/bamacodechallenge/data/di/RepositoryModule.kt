package com.raana.bamacodechallenge.data.di

import com.raana.bamacodechallenge.data.service.post.PostServicesImpl
import com.raana.bamacodechallenge.data.service.user.UserServicesImpl
import com.raana.bamacodechallenge.domain.repository.post.PostRepository
import com.raana.bamacodechallenge.domain.repository.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providePostRepository(impl: PostServicesImpl): PostRepository = impl

    @Provides
    @ViewModelScoped
    fun provideUserRepository(impl: UserServicesImpl): UserRepository = impl
}