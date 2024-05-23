package dev.lipscomb.ghstars.data.models

import java.time.LocalDate

data class GitHubRepo(
    val id: Long,
    val name: String,
    val url: String,
    val description: String,
    val contributorsUrl: String,
    val stars: Int,
    val watchers: Int,
    val topics: List<String>,
    val lastUpdated: LocalDate,
    val owner: GitHubRepoOwner,
    val topContributor: GitHubRepoContributor? = null
)
