package ll.peekabuytest.uis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ll.peekabuytest.R;
import ll.peekabuytest.adapters.InspirationLookAdapter;
import ll.peekabuytest.models.events.InspirationLoadingEvent;
import ll.peekabuytest.models.InspirationLook;

/**
 * Created by Le on 2016/3/9.
 */
public class InspirationFragment extends BaseFragment {
    @Bind(R.id.id_recyclerview_horizontal_inspiration)
    RecyclerView mRecyclerView;

    private InspirationLookAdapter mAdapter;
    private List<InspirationLook> mInspirationLookList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inspiration, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new InspirationLookAdapter(this.getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(InspirationLoadingEvent event) {
        mInspirationLookList = event.getInspirationLookList();
        Log.v("Event", mInspirationLookList.toString());
        mAdapter.setDatas(mInspirationLookList);
    }


}
