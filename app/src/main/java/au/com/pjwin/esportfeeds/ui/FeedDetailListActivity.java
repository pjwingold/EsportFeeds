package au.com.pjwin.esportfeeds.ui;

import android.os.Bundle;

import org.jetbrains.annotations.Nullable;

import au.com.pjwin.commonlib.ui.Arg;
import au.com.pjwin.commonlib.ui.SwipeRefreshActivity;
import au.com.pjwin.commonlib.ui.ViewActivity;
import au.com.pjwin.esportfeeds.R;

public class FeedDetailListActivity extends ViewActivity
        implements SwipeRefreshActivity {

    @Override
    public int pageTitle() {
        return R.string.detail_title;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String category = getExtra(Arg.FIRST);
        String source = getExtra(Arg.SECOND);

        if (savedInstanceState == null) {
            showFragment(FeedDetailListFragment.newInstance(category, source));
        }
    }

    @Override
    public void performRefresh(boolean force) {
        FeedDetailListFragment fragment = getExistingFragment();
        if (fragment != null) {
            fragment.loadFeedDetails(true);
        }
    }
}
