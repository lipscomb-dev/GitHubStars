package dev.lipscomb.ghstars.domain.interfaces

import dev.lipscomb.ghstars.data.models.GitHubRepoContributor

interface FetchGitHubRepoTopContributorUseCase {
    suspend fun fetch(owner: String, repo: String): GitHubRepoContributor?
}