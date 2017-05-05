package io.charliealbright.githubsearch.network;

import io.charliealbright.githubsearch.model.GithubSearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Charlie on 5/5/2017.
 */

public interface GithubApiService {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/search/users")
    Call<GithubSearchResult> search(@Query("q") String query);

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/users/{username}")
    Call<GithubSearchResult> getUser(@Path("username") String username);
}
