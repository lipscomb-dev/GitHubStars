package dev.lipscomb.ghstars.ui.views.repositorylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.lipscomb.ghstars.R
import dev.lipscomb.ghstars.data.models.GitHubRepo
import dev.lipscomb.ghstars.ui.theme.AppTypography

@Composable
fun RepoListItem(
    modifier: Modifier = Modifier,
    repo: GitHubRepo,
    fetchTopContributor: (GitHubRepo) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AsyncImage(
                    model = repo.owner.avatarUrl,
                    contentDescription = stringResource(R.string.owner_avatar_image_content_description),
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${repo.owner.login}/${repo.name}",
                    style = AppTypography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = repo.description,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                repo.topics.forEach { topic ->
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                    ) {
                        Text(
                            text = topic,
                            color = Color.Black,
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                                .padding(vertical = 4.dp, horizontal = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(imageVector = Icons.Default.Star, contentDescription = stringResource(R.string.stars_content_description))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = repo.stars.toString(),
                        style = AppTypography.bodyMedium,
                    )
                }
                Spacer(Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = repo.watchers.toString(),
                        style = AppTypography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(imageVector = Icons.Default.Face, contentDescription = stringResource(R.string.watchers_content_description))
                }
            }
            if (repo.topContributor != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.top_contributor_label),
                        fontWeight = FontWeight.SemiBold
                    )
                    AsyncImage(
                        model = repo.topContributor.avatarUrl,
                        contentDescription = stringResource(R.string.top_contributor_avatar_image_content_description),
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = repo.topContributor.login,
                    )
                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = {
                        fetchTopContributor(repo)
                    }) {
                        Text(stringResource(R.string.tap_to_load_top_contributor))
                    }
                }
            }
        }
    }
}