package au.com.pjwin.esportfeeds.ui;

import android.content.Context;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import au.com.pjwin.commonlib.ui.adapter.ListClickListener;
import au.com.pjwin.commonlib.ui.adapter.RecyclerListAdapter;
import au.com.pjwin.commonlib.ui.adapter.RecyclerViewHolder;
import au.com.pjwin.esportfeeds.R;
import au.com.pjwin.esportfeeds.databinding.FeedEntryItemBinding;
import au.com.pjwin.esportfeeds.model.FeedEntry;

public class FeedEntryListAdapter extends RecyclerListAdapter<FeedEntry, FeedEntryItemBinding, RecyclerViewHolder> {

    public FeedEntryListAdapter(@NonNull Context context, List<FeedEntry> entryList, ListClickListener<FeedEntry> listener) {
        super(context, entryList, listener);
    }

    @Override
    protected int layoutId() {
        return R.layout.feed_entry_item;
    }

    @Override
    protected void bindData(@NotNull FeedEntryItemBinding binding, FeedEntry feedEntry) {
        binding.setEntry(feedEntry);
    }
}
