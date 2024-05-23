package dev.lipscomb.ghstars.data.remote.models

import com.google.gson.annotations.SerializedName

data class APIGitHubRepoOwner(
    val id: Long?,
    val login: String?,
    @SerializedName("avatar_url") val avatarUrl: String?
)