package io.charliealbright.githubsearch.presenter;

import io.charliealbright.githubsearch.model.GithubSearchResult;
import io.charliealbright.githubsearch.network.GithubApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Charlie on 5/6/17.
 */

public class SearchResultPresenter implements SearchResultContract.Presenter {

    private SearchResultContract.View mSearchResultView;
    private Retrofit mRetrofit;
    private GithubApiService mGithubApiService;

    public SearchResultPresenter(SearchResultContract.View view) {
        mSearchResultView = view;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(GithubApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mGithubApiService = mRetrofit.create(GithubApiService.class);
    }

    @Override
    public void start() {

    }

    @Override
    public void performSearch(String query) {
        mSearchResultView.showLoadingOverlay();
        mGithubApiService.search(query).enqueue(new Callback<GithubSearchResult>() {
            @Override
            public void onResponse(Call<GithubSearchResult> call, Response<GithubSearchResult> response) {
                GithubSearchResult result = response.body();
                if (result != null) {
                    Timber.tag("[Retrofit][onResponse]").d("resultCount = %d", result.getResultCount());
                    mSearchResultView.hideLoadingOverlay();
                    mSearchResultView.addItems(result.getUserList());
                } else {
                    Timber.tag("[Retrofit][onResponse]").w("response is empty - most likely the rate limit was exceeded.");
                    mSearchResultView.showRateLimitExceededError();
                    mSearchResultView.hideLoadingOverlay();
                }
            }

            @Override
            public void onFailure(Call<GithubSearchResult> call, Throwable t) {
                Timber.tag("[Retrofit][onFailure]").wtf(t);
            }
        });
    }
}
