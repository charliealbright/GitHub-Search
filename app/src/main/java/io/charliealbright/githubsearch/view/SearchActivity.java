package io.charliealbright.githubsearch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.presenter.SearchContract;
import io.charliealbright.githubsearch.presenter.SearchPresenter;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private SearchPresenter mPresenter;

    private View mRootView;
    private TextInputLayout mSearchField;
    private FloatingActionButton mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRootView = findViewById(R.id.activity_search_root);
        mSearchField = (TextInputLayout)findViewById(R.id.activity_search_field);
        mSearchButton = (FloatingActionButton) findViewById(R.id.activity_search_button);
        mPresenter = new SearchPresenter(this);

        mSearchButton.setOnClickListener(mOnSearchButtonClickListener);

        if (savedInstanceState != null) {
            String query = savedInstanceState.getString("query");
            mSearchField.getEditText().setText(query);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String query = mSearchField.getEditText().getText().toString();
        outState.putString("query", query);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showLoadingOverlay() {

    }

    @Override
    public void hideLoadingOverlay() {

    }

    @Override
    public void showSearchValidationError() {
        Snackbar.make(mRootView, getString(R.string.search_error_message), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void navigateToNextScreen(String query) {
        // Navigate to SearchResultsActivity
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

    private View.OnClickListener mOnSearchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mSearchField.getEditText() != null) {
                mPresenter.searchClicked(mSearchField.getEditText().getText().toString());
            }
        }
    };
}
