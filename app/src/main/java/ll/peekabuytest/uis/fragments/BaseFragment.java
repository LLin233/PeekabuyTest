package ll.peekabuytest.uis.fragments;

import android.support.v4.app.Fragment;

import de.greenrobot.event.EventBus;

/**
 * Created by Le on 2016/3/8.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        if (isStickyAvailable()) {
            EventBus.getDefault().registerSticky(this);
        } else {
            EventBus.getDefault().register(this);
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    protected boolean isStickyAvailable() {
        return false;
    }
}
