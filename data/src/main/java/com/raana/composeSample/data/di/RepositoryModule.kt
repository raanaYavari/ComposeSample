package com.raana.composeSample.data.di

import com.raana.composeSample.data.service.post.PostServicesImpl
import com.raana.composeSample.data.service.user.UserServicesImpl
import com.raana.composeSample.domain.repository.post.PostRepository
import com.raana.composeSample.domain.repository.user.UserRepository
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