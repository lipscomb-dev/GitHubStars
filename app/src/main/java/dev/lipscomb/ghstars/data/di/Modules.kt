package dev.lipscomb.ghstars.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.lipscomb.ghstars.data.remote.services.Endpoints
import dev.lipscomb.ghstars.data.remote.services.GitHubApiService
import dev.lipscomb.ghstars.data.repositories.interfaces.GitHubRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modules {
    @Provides
    fun providesBaseUrl(): String = Endpoints.Github.API_BASE_URL

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: String) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesGitHubAPIService(retrofit: Retrofit): GitHubApiService =
        retrofit.create(GitHubApiService::class.java)

    @Provides
    @Singleton
    fun providesGitHubRepository(apiService: GitHubApiService): GitHubRepository =
        dev.lipscomb.ghstars.data.repositories.GitHubRepository(apiService)
}