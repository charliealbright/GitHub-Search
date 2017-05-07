package io.charliealbright.githubsearch.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.presenter.SearchResultContract;
import io.charliealbright.githubsearch.presenter.SearchResultPresenter;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultContract.View {

    private SearchResultPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");

        mPresenter = new SearchResultPresenter(this);
        mPresenter.performSearch(query);
    }

    @Override
    public void showLoadingOverlay() {

    }

    @Override
    public void hideLoadingOverlay() {

    }
}
