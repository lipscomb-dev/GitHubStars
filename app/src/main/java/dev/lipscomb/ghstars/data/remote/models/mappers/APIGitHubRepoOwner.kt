package dev.lipscomb.ghstars.data.remote.models.mappers

import dev.lipscomb.ghstars.data.models.GitHubRepoOwner
import dev.lipscomb.ghstars.data.remote.models.APIGitHubRepoOwner

fun APIGitHubRepoOwner.toDomain(): GitHubRepoOwner? {
    val id = id ?: return null
    val login = login ?: return null
    return GitHubRepoOwner(id, login, avatarUrl)
}