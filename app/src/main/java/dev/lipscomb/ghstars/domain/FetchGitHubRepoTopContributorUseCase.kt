package dev.lipscomb.ghstars.domain

import dev.lipscomb.ghstars.data.models.GitHubRepoContributor
import dev.lipscomb.ghstars.data.repositories.interfaces.GitHubRepository
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubRepoTopContributorUseCase
import javax.inject.Inject

class FetchGitHubRepoTopContributorUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : FetchGitHubRepoTopContributorUseCase {
    override suspend fun fetch(owner: String, repo: String): GitHubRepoContributor? {
        return gitHubRepository.fetchRepoContributors(owner, repo).firstOrNull()
    }
}