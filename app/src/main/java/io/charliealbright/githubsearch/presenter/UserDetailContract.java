package io.charliealbright.githubsearch.presenter;

/**
 * Created by Charlie on 5/7/2017.
 */

public interface UserDetailContract {

    interface View extends BaseView<Presenter> {

        void populateFullNameLabel(String text);

        void populateUserNameLabel(String text);

        void populateRepositoryLabel(String text);

        void populateFollowersLabel(String text);

        void populateLocationLabel(String text);

        void setLocationUnknown();

        void populateBioLabel(String text);

        void setBioEmptyMessage();

        void populateAvatar(String imageUrl);

        void showTypeIcon(boolean isCompany);

        void showAdminIcon();

        void showLoadingOverlay();

        void hideLoadingOverlay();
    }

    interface Presenter extends BasePresenter {

        void loadUserDetails(String username);
    }
}
