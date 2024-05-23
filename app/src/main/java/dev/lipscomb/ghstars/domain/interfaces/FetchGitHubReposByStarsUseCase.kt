package dev.lipscomb.ghstars.domain.interfaces

import dev.lipscomb.ghstars.data.models.GitHubRepo

interface FetchGitHubReposByStarsUseCase {
    suspend fun fetch(): List<GitHubRepo>
}