package dev.lipscomb.ghstars.ui.views.repositorylist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.lipscomb.ghstars.data.models.GitHubRepo
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubRepoTopContributorUseCase
import dev.lipscomb.ghstars.domain.interfaces.FetchGitHubReposByStarsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val fetchRepos: FetchGitHubReposByStarsUseCase,
    private val fetchTopContributor: FetchGitHubRepoTopContributorUseCase
) : ViewModel() {
    private var storedRepos = listOf<GitHubRepo>()
    private val _uiState = MutableStateFlow<RepoListUiState>(RepoListUiState.Loading)
    val uiState: StateFlow<RepoListUiState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                storedRepos = fetchRepos.fetch()
                setReadyState(storedRepos)
            } catch (exception: Exception) {
                setErrorState(exception)
            }
        }
    }

    fun fetchTopContributor(repo: GitHubRepo) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val topContributor = fetchTopContributor.fetch(repo.owner.login, repo.name)
                val index = storedRepos.indexOf(repo)
                val updatedRepos = storedRepos.toMutableList()
                updatedRepos[index] = repo.copy(topContributor = topContributor)
                setReadyState(updatedRepos)
            } catch (exception: Exception) {
                setErrorState(exception)
            }
        }
    }

    private fun setErrorState(exception: Exception) {
        Log.e("RepoListViewModel", "Fetch Error: $exception")
        _uiState.update { RepoListUiState.Error }
    }

    private fun setReadyState(repos: List<GitHubRepo>) {
        _uiState.update { RepoListUiState.Ready(repos = repos) }
    }
}