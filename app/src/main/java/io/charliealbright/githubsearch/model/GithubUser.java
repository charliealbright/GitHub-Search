package io.charliealbright.githubsearch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Charlie on 5/5/2017.
 */

public class GithubUser implements Parcelable {

    @SerializedName("login")
    private String mUsername;

    @SerializedName("id")
    private int mId;

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

    @SerializedName("location")
    private String mLocation;

    @SerializedName("bio")
    private String mBio;

    @SerializedName("public_repos")
    private int mRepoCount;

    @SerializedName("followers")
    private int mFollowerCount;

    public GithubUser(Parcel parcel) {
        mUsername = parcel.readString();
        mId = parcel.readInt();
        mAvatarUrl = parcel.readString();
        mProfileUrl = parcel.readString();
        mType = parcel.readString();
        mIsAdmin = parcel.readByte() != 0;
        mFullName = parcel.readString();
        mLocation = parcel.readString();
        mBio = parcel.readString();
        mRepoCount = parcel.readInt();
        mFollowerCount = parcel.readInt();
    }

    public String getUsername() {
        return mUsername;
    }

    public int getId() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUsername);
        parcel.writeInt(mId);
        parcel.writeString(mAvatarUrl);
        parcel.writeString(mProfileUrl);
        parcel.writeString(mType);
        parcel.writeByte((byte) (mIsAdmin ? 1 : 0));
        parcel.writeString(mFullName);
        parcel.writeString(mLocation);
        parcel.writeString(mBio);
        parcel.writeInt(mRepoCount);
        parcel.writeInt(mFollowerCount);
    }

    public static final Parcelable.Creator<GithubUser> CREATOR = new Parcelable.Creator<GithubUser>() {

        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int i) {
            return new GithubUser[i];
        }
    };
}
