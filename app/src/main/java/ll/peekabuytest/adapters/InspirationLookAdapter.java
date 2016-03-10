package ll.peekabuytest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ll.peekabuytest.R;
import ll.peekabuytest.models.InspirationLook;

/**
 * Created by Le on 2016/3/9.
 */
public class InspirationLookAdapter extends
        RecyclerView.Adapter<InspirationLookAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<InspirationLook> mDatas;
    private Context mContext;

    public InspirationLookAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = Collections.emptyList();
    }

    public void setDatas(List<InspirationLook> looks) {
        mDatas = null;
        mDatas = looks;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.inspiration_look_image)
        ImageView mInspirationLookImageView;
        @Bind(R.id.creator_avatar)
        ImageView mAvatarImageView;
        @Bind(R.id.creator_username)
        TextView mUsernameTextView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_inspiration_look_list,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        InspirationLook item = mDatas.get(i);
        Glide.with(mContext)
                .load(item.image_url)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.mInspirationLookImageView);
        Glide.with(mContext)
                .load(item.creator.avatar_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.mAvatarImageView);
        viewHolder.mUsernameTextView.setText(item.creator.name);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Glide.clear(holder.mInspirationLookImageView);
        Glide.clear(holder.mAvatarImageView);
    }

}
