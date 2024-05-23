package dev.lipscomb.ghstars.ui.views.repositorylist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import dev.lipscomb.ghstars.R
import dev.lipscomb.ghstars.ui.views.shared.ErrorScreen
import dev.lipscomb.ghstars.ui.views.shared.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepositoryList(viewModel: RepoListViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) { innerPadding ->
        when (val state = uiState) {
            is RepoListUiState.Loading -> LoadingScreen()
            is RepoListUiState.Error -> ErrorScreen()
            is RepoListUiState.Ready -> {
                RepoListItems(
                    modifier = Modifier.padding(innerPadding),
                    repos = state.repos,
                    fetchTopContributor = { viewModel.fetchTopContributor(it) })
            }
        }
    }
}