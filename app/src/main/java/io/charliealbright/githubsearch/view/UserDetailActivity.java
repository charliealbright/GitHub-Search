package io.charliealbright.githubsearch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.presenter.UserDetailContract;
import io.charliealbright.githubsearch.presenter.UserDetailPresenter;

public class UserDetailActivity extends AppCompatActivity implements UserDetailContract.View {

    private UserDetailPresenter mPresenter;
    private String mUsername;

    private TextView mFullNameLabel;
    private TextView mUserNameLabel;
    private TextView mRepositoryLabel;
    private TextView mFollowersLabel;
    private TextView mLocationLabel;
    private TextView mBioLabel;

    private ImageView mAvatar;
    private ImageView mUserTypeIcon;
    private ImageView mAdminIcon;

    private View mLoadingOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFullNameLabel = (TextView)findViewById(R.id.activity_user_detail_fullname);
        mUserNameLabel = (TextView)findViewById(R.id.activity_user_detail_username);
        mRepositoryLabel = (TextView)findViewById(R.id.activity_user_detail_repo_text);
        mFollowersLabel = (TextView)findViewById(R.id.activity_user_detail_follower_text);
        mLocationLabel = (TextView)findViewById(R.id.activity_user_detail_location_text);
        mBioLabel = (TextView)findViewById(R.id.activity_user_detail_bio);

        mAvatar = (ImageView)findViewById(R.id.activity_user_detail_image_view);
        mUserTypeIcon = (ImageView)findViewById(R.id.activity_user_detail_type_icon);
        mAdminIcon = (ImageView)findViewById(R.id.activity_user_detail_admin_icon);

        mLoadingOverlay = findViewById(R.id.activity_user_detail_loading_overlay);

        mPresenter = new UserDetailPresenter(this);

        Intent intent = getIntent();
        mUsername = intent.getStringExtra("username");
        mPresenter.loadUserDetails(mUsername);

        getSupportActionBar().setTitle(mUsername);
    }

    @Override
    public void populateFullNameLabel(String text) {
        mFullNameLabel.setText(text);
    }

    @Override
    public void populateUserNameLabel(String text) {
        mUserNameLabel.setText(text);
    }

    @Override
    public void populateRepositoryLabel(String text) {
        mRepositoryLabel.setText(text);
    }

    @Override
    public void populateFollowersLabel(String text) {
        mFollowersLabel.setText(text);
    }

    @Override
    public void populateLocationLabel(String text) {
        mLocationLabel.setText(text);
    }

    @Override
    public void setLocationUnknown() {
        mLocationLabel.setText(R.string.empty_location_message);
    }

    @Override
    public void populateBioLabel(String text) {
        mBioLabel.setText(text);
    }

    @Override
    public void setBioEmptyMessage() {
        mBioLabel.setText(getString(R.string.empty_bio_message));
    }

    @Override
    public void populateAvatar(String imageUrl) {
        Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .crossFade()
                .into(mAvatar);
    }

    @Override
    public void showTypeIcon(boolean isCompany) {
        if (isCompany) {
            mUserTypeIcon.setImageResource(R.drawable.ic_business_white_24dp);
        } else {
            mUserTypeIcon.setImageResource(R.drawable.ic_person_white_24dp);
        }
    }

    @Override
    public void showAdminIcon() {
        mAdminIcon.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadingOverlay() {
        mLoadingOverlay.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingOverlay() {
        mLoadingOverlay.setVisibility(View.GONE);
    }
}
