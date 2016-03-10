package ll.peekabuytest.uis.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import ll.peekabuytest.Constants;
import ll.peekabuytest.OutfitImageView;
import ll.peekabuytest.R;
import ll.peekabuytest.models.OutfitLoadingEvent;
import ll.peekabuytest.networks.APIEndpoint;

public class OutfitFragment extends BaseFragment {

    @Bind(R.id.fragment_outfit_look)
    OutfitImageView mOutfitView;
    @Bind(R.id.fragment_outfit_loadingProgressBar)
    ProgressBar mProgressBar;

    private Context mContext;
    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            mOutfitView.setImageBitmap(bitmap);
        }
    };

    public OutfitFragment() {
        // Required empty public constructor
    }

    public static OutfitFragment newInstance(String param1, String param2) {
        OutfitFragment fragment = new OutfitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        APIEndpoint.requestUserOutfit(Constants.TEST_USERNAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_outfit, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOutfitView.setOnTouchListener(mOutfitView);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onOutfitLoadingEvent(OutfitLoadingEvent event) {
        if (mProgressBar.isIndeterminate()) {
            mOutfitView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
        Glide.with(mContext)
                .load(event.getLook().image_url)
                .asBitmap()
                .into(target);
        mOutfitView.setProducts(event.getLook().products);
    }
}
