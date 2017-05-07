package io.charliealbright.githubsearch.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.charliealbright.githubsearch.R;
import io.charliealbright.githubsearch.model.GithubUser;

/**
 * Created by Charlie on 5/7/2017.
 */

public class SearchResultItemAdapter extends RecyclerView.Adapter<SearchResultItemAdapter.ViewHolder> {

    private Context mContext;
    private List<GithubUser> mUserList;

    public SearchResultItemAdapter(Context context, List<GithubUser> userList) {
        mContext = context;
        mUserList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_result_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GithubUser user = mUserList.get(position);

        holder.mUsernameTextView.setText(user.getUsername());
        Glide.with(mContext)
                .load(user.getAvatarUrl())
                .fitCenter()
                .crossFade()
                .into(holder.mAvatarImageView);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Glide.clear(holder.mAvatarImageView);
    }

    public List<GithubUser> getUserList() {
        return mUserList;
    }

    public void addItemsAndNotify(List<GithubUser> usersToAdd) {
        int itemCount = usersToAdd.size();
        mUserList.addAll(usersToAdd);
        notifyItemRangeInserted(getItemCount() - 1, itemCount);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        ImageView mAvatarImageView;
        TextView mUsernameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView)itemView.findViewById(R.id.search_result_item_cardview);
            mAvatarImageView = (ImageView)itemView.findViewById(R.id.search_result_item_image);
            mUsernameTextView = (TextView)itemView.findViewById(R.id.search_result_item_text);
        }
    }
}
