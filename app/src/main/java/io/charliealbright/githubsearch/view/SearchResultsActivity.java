package io.charliealbright.githubsearch.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.model.GithubUser;
import io.charliealbright.githubsearch.presenter.SearchResultContract;
import io.charliealbright.githubsearch.presenter.SearchResultPresenter;
import timber.log.Timber;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultContract.View {

    private SearchResultPresenter mPresenter;

    private View mOverlay;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        mOverlay = findViewById(R.id.activity_search_result_overlay);
        mRecyclerView = (RecyclerView)findViewById(R.id.activity_search_result_recyclerview);

        mPresenter = new SearchResultPresenter(this);
        mPresenter.performSearch(query);
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
    public void addItems(List<GithubUser> userList) {
        if (!userList.isEmpty()) {
            for (GithubUser user : userList) {
                Timber.tag("[addItems]").d("username = %s", user.getUsername());
            }
        }
    }
}
