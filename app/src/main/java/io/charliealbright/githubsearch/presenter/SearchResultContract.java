package io.charliealbright.githubsearch.presenter;

/**
 * Created by Charlie on 5/6/17.
 */

public interface SearchResultContract {

    interface View extends BaseView<Presenter> {

        void showLoadingOverlay();

        void hideLoadingOverlay();


    }

    interface Presenter extends BasePresenter {

        void performSearch(String query);
    }
}
