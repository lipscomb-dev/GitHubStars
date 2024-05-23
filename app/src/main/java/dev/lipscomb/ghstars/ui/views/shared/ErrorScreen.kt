package dev.lipscomb.ghstars.ui.views.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.lipscomb.ghstars.R
import dev.lipscomb.ghstars.ui.theme.AppTypography

@Composable
fun ErrorScreen(message: String = stringResource(R.string.generic_error_message)) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            style = AppTypography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewErrorScreen() {
    ErrorScreen()
}