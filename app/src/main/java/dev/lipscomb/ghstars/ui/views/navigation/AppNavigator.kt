package dev.lipscomb.ghstars.ui.views.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.lipscomb.ghstars.ui.views.repositorylist.RepositoryList
import dev.lipscomb.ghstars.ui.theme.AppTheme

@Composable
fun AppNavigator(navController: NavHostController) {
    AppTheme {
        Surface {
            NavHost(
                navController = navController,
                startDestination = Screens.RepoList.route
            ) {
                composable(Screens.RepoList.route) {
                    RepositoryList()
                }
            }
        }
    }
}