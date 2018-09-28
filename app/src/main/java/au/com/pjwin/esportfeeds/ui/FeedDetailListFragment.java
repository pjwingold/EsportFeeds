package au.com.pjwin.esportfeeds.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.com.pjwin.commonlib.ui.Arg;
import au.com.pjwin.commonlib.ui.BaseFragment;
import au.com.pjwin.esportfeeds.R;
import au.com.pjwin.esportfeeds.databinding.FragmentFeedDetailListBinding;
import au.com.pjwin.esportfeeds.model.FeedEntry;
import au.com.pjwin.esportfeeds.model.FeedResponse;
import au.com.pjwin.esportfeeds.viewmodel.FeedViewModel;

//todo different orientation
public class FeedDetailListFragment extends BaseFragment<FeedResponse, FeedViewModel, FragmentFeedDetailListBinding> {

    private String category;
    private String source;

    private List<FeedEntry> entryList;
    private FeedDetailListAdapter feedDetailListAdapter;

    public static FeedDetailListFragment newInstance(String category, String source) {
        return new FeedDetailListFragment().setArguments(category, source);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_feed_detail_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = getArgument(Arg.FIRST);
        source = getArgument(Arg.SECOND);
        entryList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFeedDetails(false);

        binding.feedDetailList.setHasFixedSize(true);
        binding.feedDetailList.addItemDecoration(new DividerItemDecoration(
                getContext(), LinearLayoutManager.VERTICAL));
        feedDetailListAdapter = new FeedDetailListAdapter(getContext(),
                entryList);
        binding.feedDetailList.setAdapter(feedDetailListAdapter);
    }

    @Override
    public void onData(@Nullable FeedResponse feedResponse) {
        if (feedResponse != null) {
            entryList = feedResponse.getFeedEntryList();
            feedDetailListAdapter.setList(entryList);
        }
    }

    public void loadFeedDetails(boolean force) {
        getViewModel().getFeedDetails(category, source, force);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        setRefreshing(false);
    }
}
