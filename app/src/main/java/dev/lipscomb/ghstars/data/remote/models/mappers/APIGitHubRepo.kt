package dev.lipscomb.ghstars.data.remote.models.mappers

import dev.lipscomb.ghstars.data.models.GitHubRepo
import dev.lipscomb.ghstars.data.remote.models.APIGitHubRepo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object APIGitHubRepositoryParsers {
    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
}

fun APIGitHubRepo.toDomain(): GitHubRepo? {
    val id = id ?: return null
    val name = name ?: return null
    val url = url ?: return null
    val description = description ?: ""
    val contributorsUrl = contributorsUrl ?: return null
    val stars = stars ?: return null
    val watchers = watchers ?: return null
    val topics = topics ?: listOf()
    val lastUpdated =
        lastUpdated?.let { LocalDate.parse(it, APIGitHubRepositoryParsers.dateTimeFormatter) }
            ?: return null
    val owner = owner?.toDomain() ?: return null

    return GitHubRepo(
        id = id,
        name = name,
        url = url,
        description = description,
        contributorsUrl = contributorsUrl,
        stars = stars,
        watchers = watchers,
        topics = topics,
        lastUpdated = lastUpdated,
        owner = owner
    )
}

fun List<APIGitHubRepo>.toDomain(): List<GitHubRepo> = mapNotNull { it.toDomain() }