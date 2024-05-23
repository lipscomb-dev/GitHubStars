package dev.lipscomb.ghstars.data.remote.models.mappers

import dev.lipscomb.ghstars.data.models.GitHubRepoContributor
import dev.lipscomb.ghstars.data.remote.models.APIGitHubRepoContributor

fun APIGitHubRepoContributor.toDomain(): GitHubRepoContributor? {
    val login = login ?: return null
    val id = id ?: return null
    return GitHubRepoContributor(
        login = login,
        id = id,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl
    )
}

fun List<APIGitHubRepoContributor>.toDomain() = mapNotNull { it.toDomain() }