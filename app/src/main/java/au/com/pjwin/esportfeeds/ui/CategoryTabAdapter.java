package au.com.pjwin.esportfeeds.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import au.com.pjwin.esportfeeds.model.CategoryCollection;

public class CategoryTabAdapter extends FragmentPagerAdapter {

    private List<CategoryCollection> categories;
    private List<FeedListFragment> fragmentList;

    public CategoryTabAdapter(FragmentManager fragmentManager, @NonNull List<CategoryCollection> categories) {
        super(fragmentManager);
        this.categories = categories;
        fragmentList = new ArrayList<>(categories.size());
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("CategoryTabAdapter", "getItem: ");
        FeedListFragment fragment = FeedListFragment.newInstance(categories.get(position).getId());
        fragmentList.add(fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CategoryCollection item = categories.get(position);

        return !TextUtils.isEmpty(item.getAbbrName()) ? item.getAbbrName() : item.getTitle();
    }

    public FeedListFragment getSelectedFragment(int position) {
        return fragmentList.get(position);
    }

}
