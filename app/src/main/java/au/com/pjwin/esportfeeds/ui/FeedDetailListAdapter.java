package au.com.pjwin.esportfeeds.ui;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import au.com.pjwin.commonlib.ui.adapter.RecyclerListAdapter;
import au.com.pjwin.commonlib.ui.adapter.RecyclerViewHolder;
import au.com.pjwin.esportfeeds.R;
import au.com.pjwin.esportfeeds.databinding.FeedDetailItemBinding;
import au.com.pjwin.esportfeeds.model.FeedEntry;

public class FeedDetailListAdapter extends RecyclerListAdapter<FeedEntry, FeedDetailItemBinding, RecyclerViewHolder> {

    public FeedDetailListAdapter(Context context, List<FeedEntry> entryList) {
        super(context, entryList);
    }

    @Override
    protected int layoutId() {
        return R.layout.feed_detail_item;
    }

    @Override
    protected void bindData(@NotNull FeedDetailItemBinding binding, FeedEntry feedEntry) {
        binding.setEntry(feedEntry);
    }
}
