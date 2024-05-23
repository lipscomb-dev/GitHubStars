package dev.lipscomb.ghstars.data.repositories.interfaces

import dev.lipscomb.ghstars.data.models.GitHubRepo
import dev.lipscomb.ghstars.data.models.GitHubRepoContributor

interface GitHubRepository {
    suspend fun fetchGitHubRepositories(): List<GitHubRepo>
    suspend fun fetchRepoContributors(owner: String, repo: String): List<GitHubRepoContributor>
}