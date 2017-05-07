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

    public String getUsername() {
        return mUsername;
    }

    public String getId() {
        return mId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getProfileUrl() {
        return mProfileUrl;
    }

    public String getType() {
        return mType;
    }

    public boolean isAdmin() {
        return mIsAdmin;
    }

    public String getFullName() {
        return mFullName;
    }

    @Nullable
    public String getCompany() {
        return mCompany;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getBio() {
        return mBio;
    }

    public int getRepoCount() {
        return mRepoCount;
    }

    public int getFollowerCount() {
        return mFollowerCount;
    }
}
