package dev.lipscomb.ghstars.data.repositories

import dev.lipscomb.ghstars.data.models.GitHubRepoContributor
import dev.lipscomb.ghstars.data.remote.models.mappers.toDomain
import dev.lipscomb.ghstars.data.remote.services.GitHubApiService
import dev.lipscomb.ghstars.data.repositories.interfaces.GitHubRepository
import javax.inject.Inject

class GitHubRepository @Inject constructor(
    private val gitHubApiService: GitHubApiService
) : GitHubRepository {
    override suspend fun fetchGitHubRepositories() =
        gitHubApiService.fetchRepositories().body()?.items?.toDomain() ?: listOf()

    override suspend fun fetchRepoContributors(
        owner: String,
        repo: String
    ): List<GitHubRepoContributor> {
        val response = gitHubApiService.fetchContributors(owner = owner, repo = repo).body()
        return response?.toDomain() ?: listOf()
    }
}