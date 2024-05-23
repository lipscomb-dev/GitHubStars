package dev.lipscomb.ghstars.ui.views.repositorylist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dev.lipscomb.ghstars.ui.views.shared.ErrorScreen
import dev.lipscomb.ghstars.ui.views.shared.LoadingScreen

@Composable
fun RepositoryList(viewModel: RepoListViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    when (val state = uiState) {
        is RepoListUiState.Loading -> LoadingScreen()
        is RepoListUiState.Error -> ErrorScreen()
        is RepoListUiState.Ready -> {
            RepoListItems(
                repos = state.repos,
                fetchTopContributor = { viewModel.fetchTopContributor(it) })
        }
    }
}