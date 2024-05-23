package dev.lipscomb.ghstars.ui.views.repositorylist

import dev.lipscomb.ghstars.data.models.GitHubRepo

sealed class RepoListUiState {
    data object Loading : RepoListUiState()
    data object Error : RepoListUiState()
    data class Ready(
        val repos: List<GitHubRepo>
    ) : RepoListUiState()
}
