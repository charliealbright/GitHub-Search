package io.charliealbright.githubsearch.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Charlie on 5/5/2017.
 */

public class GithubUser {

    @SerializedName("login")
    private String mUsername;

    @SerializedName("id")
    private String mId;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("html_url")
    private String mProfileUrl;

    @SerializedName("type")
    private String mType;

    @SerializedName("site_admin")
    private boolean mIsAdmin;

    @SerializedName("name")
    private String mFullName;

    @Nullable
    @SerializedName("company")
    private String mCompany;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("bio")
    private String mBio;

    @SerializedName("public_repos")
    private int mRepoCount;

    @SerializedName("followers")
    private int mFollowerCount;
}
