package ll.peekabuytest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ll.peekabuytest.R;
import ll.peekabuytest.models.Product;

/**
 * Created by Le on 2016/3/8.
 */
public class ProductAdapter extends
        RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Product> mDatas;
    private Context mContext;

    public ProductAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = Collections.emptyList();
    }

    public void setDatas(List<Product> products) {
        mDatas = null;
        mDatas = products;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id_index_product_item_image)
        ImageView mImageView;

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
        View view = mInflater.inflate(R.layout.item_similar_product_list,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        Glide.with(mContext)
                .load(mDatas.get(i).image_url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(viewHolder.mImageView);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Glide.clear(holder.mImageView);
    }

}

