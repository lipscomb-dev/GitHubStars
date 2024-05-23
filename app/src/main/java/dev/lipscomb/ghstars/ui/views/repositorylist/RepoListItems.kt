package dev.lipscomb.ghstars.ui.views.repositorylist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.lipscomb.ghstars.data.models.GitHubRepo

@Composable
fun RepoListItems(
    modifier: Modifier = Modifier,
    repos: List<GitHubRepo>,
    fetchTopContributor: (GitHubRepo) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(repos, key = { item -> item.id }) { repo ->
            RepoListItem(repo = repo, fetchTopContributor = fetchTopContributor)
        }
    }
}
