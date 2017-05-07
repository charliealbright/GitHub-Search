package io.charliealbright.githubsearch.presenter;

import timber.log.Timber;

/**
 * Created by Charlie on 5/5/2017.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View mSearchView;

    public SearchPresenter(SearchContract.View view) {
        mSearchView = view;
    }

    @Override
    public void start() {
        // Nothing to do on startup.
    }

    @Override
    public void searchClicked(String query) {
        if (validateQuery(query)) {
            Timber.tag("[searchClicked]").d("query = %s", query);
            mSearchView.navigateToNextScreen(query);
        } else {
            mSearchView.showSearchValidationError();
        }
    }

    @Override
    public boolean validateQuery(String query) {
        return query != null && !query.isEmpty();
    }
}
