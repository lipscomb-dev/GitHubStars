package dev.lipscomb.ghstars.data.remote.models

import com.google.gson.annotations.SerializedName

data class APIGitHubRepo(
    val id: Long?,
    val name: String?,
    val url: String?,
    val description: String?,
    @SerializedName("contributors_url") val contributorsUrl: String?,
    @SerializedName("stargazers_count") val stars: Int?,
    @SerializedName("watchers_count") val watchers: Int?,
    val topics: List<String>?,
    @SerializedName("updated_at") val lastUpdated: String?,
    val owner: APIGitHubRepoOwner?
)
