package io.charliealbright.githubsearch.presenter;

import java.util.List;

import io.charliealbright.githubsearch.model.GithubUser;

/**
 * Created by Charlie on 5/6/17.
 */

public interface SearchResultContract {

    interface View extends BaseView<Presenter> {

        void showLoadingOverlay();

        void hideLoadingOverlay();

        void showNoResultsMessage();

        void showRateLimitExceededError();

        void addItems(List<GithubUser> userList);

        void navigateToUserDetailView(String username);
    }

    interface Presenter extends BasePresenter {

        void performSearch(String query);

        void searchResultItemClicked(String username);
    }
}
