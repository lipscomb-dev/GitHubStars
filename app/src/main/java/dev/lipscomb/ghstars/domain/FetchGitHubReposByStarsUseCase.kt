package dev.lipscomb.ghstars.domain

import dev.lipscomb.ghstars.data.repositories.interfaces.GitHubRepository
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubReposByStarsUseCase
import javax.inject.Inject

class FetchGitHubReposByStarsUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : FetchGitHubReposByStarsUseCase {
    override suspend fun fetch() = gitHubRepository.fetchGitHubRepositories().toMutableList()
}