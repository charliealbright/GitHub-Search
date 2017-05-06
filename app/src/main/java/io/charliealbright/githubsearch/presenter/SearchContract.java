package io.charliealbright.githubsearch.presenter;

/**
 * Created by Charlie on 5/5/2017.
 */

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void showLoadingOverlay();

        void hideLoadingOverlay();

        void showSearchValidationError();

    }

    interface Presenter extends BasePresenter {

        void searchClicked(String query);

        boolean validateQuery(String query);
    }
}
