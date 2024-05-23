package dev.lipscomb.ghstars.data.remote.services

import dev.lipscomb.ghstars.data.remote.models.APIGitHubRepoContributor
import dev.lipscomb.ghstars.data.remote.models.FetchReposResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface GitHubApiService {

    @GET("search/repositories?q=stars:>0&limit=100&sort=stars&order=desc&per_page=100")
    suspend fun fetchRepositories(): Response<FetchReposResponse>

    @GET("repos/{owner}/{repo}/contributors")
    suspend fun fetchContributors(@Path("owner") owner: String, @Path("repo") repo: String): Response<List<APIGitHubRepoContributor>>
}