package io.charliealbright.githubsearch.presenter;

import io.charliealbright.githubsearch.model.GithubUser;
import io.charliealbright.githubsearch.network.GithubApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Charlie on 5/7/2017.
 */

public class UserDetailPresenter implements UserDetailContract.Presenter {

    private UserDetailContract.View mUserDetailView;
    private Retrofit mRetrofit;
    private GithubApiService mGithubApiService;

    public UserDetailPresenter(UserDetailContract.View view) {
        mUserDetailView = view;

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
    public void loadUserDetails(String username) {
        mUserDetailView.showLoadingOverlay();
        mGithubApiService.getUser(username).enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                GithubUser user = response.body();

                mUserDetailView.populateFullNameLabel(user.getFullName());
                mUserDetailView.populateUserNameLabel(user.getUsername());
                mUserDetailView.populateRepositoryLabel(user.getRepoCount() + " Repos");
                mUserDetailView.populateFollowersLabel(user.getFollowerCount() + " Followers");

                if (user.getLocation() != null) {
                    mUserDetailView.populateLocationLabel(user.getLocation());
                } else {
                    mUserDetailView.setLocationUnknown();
                }

                if (user.getBio() != null) {
                    mUserDetailView.populateBioLabel(user.getBio());
                } else {
                    mUserDetailView.setBioEmptyMessage();
                }

                mUserDetailView.populateAvatar(user.getAvatarUrl());
                mUserDetailView.showTypeIcon(user.getType().equals("Organization"));

                if (user.isAdmin()) {
                    mUserDetailView.showAdminIcon();
                }

                mUserDetailView.hideLoadingOverlay();
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Timber.tag("[onFailure]").wtf(t);
            }
        });
    }
}
