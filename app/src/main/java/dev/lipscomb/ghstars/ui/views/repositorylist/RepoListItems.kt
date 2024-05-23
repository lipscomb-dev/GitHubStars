package dev.lipscomb.ghstars.ui.views.repositorylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.lipscomb.ghstars.data.models.GitHubRepo
import dev.lipscomb.ghstars.ui.theme.AppTypography

@Composable
fun RepoListItems(
    modifier: Modifier = Modifier,
    repos: List<GitHubRepo>,
    fetchTopContributor: (GitHubRepo) -> Unit
) {
    Column {
        Text(
            text = "GitHub Stars",
            style = AppTypography.displaySmall,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn {
            items(repos, key = { item -> item.id }) { repo ->
                RepoListItem(repo = repo, fetchTopContributor = fetchTopContributor)
            }
        }
    }
}
