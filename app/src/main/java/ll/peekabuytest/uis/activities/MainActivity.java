package ll.peekabuytest.uis.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ll.peekabuytest.Constants;
import ll.peekabuytest.R;
import ll.peekabuytest.networks.APIEndpoint;
import ll.peekabuytest.uis.fragments.OutfitFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    void refreshContent() {
        OutfitFragment fragment = (OutfitFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_outfit);
        fragment.resetOutfit();
        APIEndpoint.requestUserOutfit(Constants.TEST_USERNAME);
    }
}
