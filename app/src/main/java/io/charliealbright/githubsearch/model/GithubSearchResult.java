package io.charliealbright.githubsearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Charlie on 5/5/2017.
 */

public class GithubSearchResult {

    @SerializedName("total_count")
    private int mResultCount;

    @SerializedName("incomplete_results")
    private boolean mResultIncomplete;

    @SerializedName("items")
    private List<GithubUser> mUserList;
}
