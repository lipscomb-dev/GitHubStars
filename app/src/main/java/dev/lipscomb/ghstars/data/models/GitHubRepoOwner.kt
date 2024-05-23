package dev.lipscomb.ghstars.data.models

import com.google.gson.annotations.SerializedName

data class GitHubRepoOwner(
    val id: Long,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String?
)
