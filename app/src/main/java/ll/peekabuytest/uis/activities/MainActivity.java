package ll.peekabuytest.uis.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ll.peekabuytest.Constants;
import ll.peekabuytest.R;
import ll.peekabuytest.models.events.FragmentChangeEvent;
import ll.peekabuytest.networks.APIEndpoint;
import ll.peekabuytest.uis.fragments.InspirationFragment;
import ll.peekabuytest.uis.fragments.OutfitFragment;
import ll.peekabuytest.uis.fragments.ProductFragment;

public class MainActivity extends AppCompatActivity {
    private InspirationFragment mInspirationFragment;
    private ProductFragment mProductFragment;
    private OutfitFragment mOutfitFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOutfitFragment = (OutfitFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_outfit);
        if (savedInstanceState == null) {
            mInspirationFragment = new InspirationFragment();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.add(R.id.content_frame, mInspirationFragment, "ONE");
            tx.commit();
        }
    }

    @OnClick(R.id.btn)
    void refreshContent() {
        if (mOutfitFragment != null) {
            mOutfitFragment.resetOutfit();
        }
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        if (mProductFragment != null && mProductFragment.isVisible()) {
            tx.hide(mProductFragment).show(mInspirationFragment).commit();
        }
        APIEndpoint.requestUserOutfit(Constants.TEST_USERNAME);
    }

    @Subscribe(sticky = true, priority = 1)
    public void onFragmentChangeEvent(FragmentChangeEvent event) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        if (event.isProductMode()) {
            if (mProductFragment == null) {
                mProductFragment = new ProductFragment();
            }
            if (!mProductFragment.isAdded()) {
                tx.hide(mInspirationFragment).add(R.id.content_frame, mProductFragment).commit();
            } else {
                tx.hide(mInspirationFragment).show(mProductFragment).commit();
            }
        } else {
            tx.hide(mProductFragment).show(mInspirationFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
