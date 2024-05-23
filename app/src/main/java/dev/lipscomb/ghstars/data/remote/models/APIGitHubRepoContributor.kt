package dev.lipscomb.ghstars.data.remote.models

import com.google.gson.annotations.SerializedName

data class APIGitHubRepoContributor(
    val login: String?,
    val id: Long?,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("html_url") val htmlUrl: String?
)
