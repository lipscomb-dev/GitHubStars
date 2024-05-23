package dev.lipscomb.ghstars.ui.views.navigation

sealed class Screens(val route: String) {
    data object RepoList: Screens("repositories/list")
}