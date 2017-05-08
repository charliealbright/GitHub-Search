package io.charliealbright.githubsearch.view;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.model.GithubUser;
import io.charliealbright.githubsearch.presenter.SearchResultContract;
import io.charliealbright.githubsearch.presenter.SearchResultPresenter;
import io.charliealbright.githubsearch.view.adapter.SearchResultItemAdapter;
import timber.log.Timber;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultContract.View {

    private SearchResultPresenter mPresenter;

    private View mOverlay;
    private RecyclerView mRecyclerView;
    private SearchResultItemAdapter mAdapter;
    private TextView mNoResultsLabel;

    private String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        mOverlay = findViewById(R.id.activity_search_result_overlay);
        mRecyclerView = (RecyclerView)findViewById(R.id.activity_search_result_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNoResultsLabel = (TextView)findViewById(R.id.activity_search_result_no_results);
        mPresenter = new SearchResultPresenter(this);

        List<GithubUser> userList = new ArrayList<>();
        if (savedInstanceState != null) {
            userList = savedInstanceState.getParcelableArrayList("userList");
            mQuery = savedInstanceState.getString("query");
            if (savedInstanceState.getBoolean("empty_message_visible")) {
                mNoResultsLabel.setVisibility(View.VISIBLE);
            }
        } else {
            Intent intent = getIntent();
            mQuery = intent.getStringExtra("query");
            mPresenter.performSearch(mQuery);
        }

        mAdapter = new SearchResultItemAdapter(getApplicationContext(), mPresenter, userList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ArrayList<GithubUser> userList = new ArrayList<>(mAdapter.getUserList());
        outState.putParcelableArrayList("userList", userList);
        outState.putString("query", mQuery);
        outState.putBoolean("empty_message_visible", mNoResultsLabel.getVisibility() == View.VISIBLE);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showLoadingOverlay() {
        mOverlay.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingOverlay() {
        mOverlay.setVisibility(View.GONE);
    }

    @Override
    public void showNoResultsMessage() {
        mNoResultsLabel.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRateLimitExceededError() {
        Snackbar.make(mOverlay, R.string.search_result_rate_limit_error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void addItems(List<GithubUser> userList) {
        if (!userList.isEmpty()) {
            mAdapter.addItemsAndNotify(userList);
        }
    }

    @Override
    public void navigateToUserDetailView(String username) {
        Timber.tag("[navigateToUserDetailView]").d("username: %s", username);
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}
