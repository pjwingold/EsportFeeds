package au.com.pjwin.esportfeeds.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.com.pjwin.commonlib.Common;
import au.com.pjwin.commonlib.ui.Arg;
import au.com.pjwin.commonlib.ui.BaseFragment;
import au.com.pjwin.esportfeeds.R;
import au.com.pjwin.esportfeeds.databinding.FragmentFeedListBinding;
import au.com.pjwin.esportfeeds.model.FeedEntry;
import au.com.pjwin.esportfeeds.model.FeedResponse;
import au.com.pjwin.esportfeeds.viewmodel.FeedViewModel;


public class FeedListFragment extends BaseFragment<FeedResponse, FeedViewModel, FragmentFeedListBinding> {

    private static final String TAG = FeedListFragment.class.getSimpleName();

    private String categoryId;

    private boolean hasMadeRequest;

    private FeedEntry selectedFeedEntry;

    private List<FeedEntry> entryList;

    private FeedEntryListAdapter listAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_feed_list;
    }

    public static FeedListFragment newInstance(String categoryId) {
        return new FeedListFragment().setArguments(categoryId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryId = getArgument(Arg.FIRST);
        Log.d(TAG, "onCreate: " + categoryId);
        entryList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated: " + categoryId);
        binding.feedEntryList.setHasFixedSize(true);
        binding.feedEntryList.addItemDecoration(new DividerItemDecoration(
                getContext(), LinearLayoutManager.VERTICAL));

        //you need to init the list with adapter,
        //otherwise you will RecyclerView: No adapter attached
        //and switching tabs will result in empty tab
        listAdapter = new FeedEntryListAdapter(
                getContext(),
                entryList,
                this::feedSelected);
        binding.feedEntryList.setAdapter(listAdapter);
    }

    /**
     * @param force swipe refresh
     */
    public void loadFeed(boolean force) {
        viewModel.getFeedByCategory(categoryId, force);
    }

    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        Log.d(TAG, "setUserVisibleHint: " + categoryId + " " + isVisibleToUser);
        //only made a request when tab is clicked, minimise user data usage
        if (isVisibleToUser) {
            if (!hasMadeRequest) {
                hasMadeRequest = true;
                Common.getUiHandler().post(() -> loadFeed(false));

            } else {
                if (entryList != null) {
                    listAdapter.setList(entryList);
                }
            }
        }
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: " + categoryId);
        super.onResume();
    }

    @Override
    public void onData(@Nullable FeedResponse feedResponse) {
        //live data should take care of activity destroy, just double check here
        if (feedResponse != null && isAdded()) {
            entryList = feedResponse.getFeedEntryList();
            Log.d(TAG, "onData: " + categoryId + " " + feedResponse.getFeedEntryList().size());
            listAdapter.setList(entryList);
        }
    }

    private void feedSelected(FeedEntry feedEntry) {
        selectedFeedEntry = feedEntry;
        onPrimaryAction();
    }

    public FeedEntry getSelectedFeedEntry() {
        return selectedFeedEntry;
    }

    @Override
    public void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressBar.setVisibility(View.GONE);
        setRefreshing(false);
    }
}
