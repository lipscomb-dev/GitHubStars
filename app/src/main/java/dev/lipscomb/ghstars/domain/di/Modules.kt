package dev.lipscomb.ghstars.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.lipscomb.ghstars.data.repositories.interfaces.GitHubRepository
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubRepoTopContributorUseCase
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubReposByStarsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modules {
    @Provides
    @Singleton
    fun providesFetchGitHubReposByStarsUseCase(gitHubRepository: GitHubRepository, fetchTopContributorUseCase: FetchGitHubRepoTopContributorUseCase): FetchGitHubReposByStarsUseCase =
        dev.lipscomb.ghstars.domain.FetchGitHubReposByStarsUseCase(gitHubRepository = gitHubRepository)

    @Provides
    @Singleton
    fun providesFetchGitHubRepoTopContributorUseCase(gitHubRepository: GitHubRepository): FetchGitHubRepoTopContributorUseCase =
        dev.lipscomb.ghstars.domain.FetchGitHubRepoTopContributorUseCase(gitHubRepository = gitHubRepository)
}