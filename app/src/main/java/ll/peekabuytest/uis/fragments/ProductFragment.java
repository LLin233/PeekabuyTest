package ll.peekabuytest.uis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ll.peekabuytest.R;
import ll.peekabuytest.adapters.ProductAdapter;
import ll.peekabuytest.models.Product;
import ll.peekabuytest.models.ProductsLoadingEvent;

/**
 * Created by Le on 2016/3/8.
 */
public class ProductFragment extends BaseFragment {
    @Bind(R.id.id_recyclerview_horizontal)
    RecyclerView mRecyclerView;
    @Bind(R.id.currentItem_image)
    ImageView mCurrentItemImage;
    @Bind(R.id.currentItem_price_label)
    TextView mTextViewPrice;
    @Bind(R.id.currentItem_description_label)
    TextView mTextViewdescription;

    private ProductAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new ProductAdapter(this.getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void handleProductsLoadingEvent(ProductsLoadingEvent event) {
        List<Product> datas = event.getSimilarProducts();
        mAdapter.setDatas(datas);
        mRecyclerView.scrollToPosition(0);
        exhibitProduct(datas.get(0));
    }

    private void exhibitProduct(Product item) {
        Glide.with(getContext())
                .load(item.image_url)
                .into(mCurrentItemImage);
        mTextViewPrice.setText(item.price);
        mTextViewdescription.setText(item.description);
    }
}
