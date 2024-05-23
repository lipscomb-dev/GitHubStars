package dev.lipscomb.ghstars.data.models

data class GitHubRepoContributor(
    val login: String,
    val id: Long,
    val avatarUrl: String?,
    val htmlUrl: String?
)