package au.com.pjwin.esportfeeds.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import au.com.pjwin.commonlib.extension.start
import au.com.pjwin.commonlib.ui.BaseActivity
import au.com.pjwin.commonlib.ui.SwipeRefreshActivity
import au.com.pjwin.esportfeeds.R
import au.com.pjwin.esportfeeds.databinding.ActivityMainBinding
import au.com.pjwin.esportfeeds.model.Service
import au.com.pjwin.esportfeeds.viewmodel.CategoryViewModel


class MainActivity : BaseActivity<Service, CategoryViewModel, ActivityMainBinding>(),
        SwipeRefreshActivity {

    private lateinit var tabPager: ViewPager
    private lateinit var tabLayout: TabLayout
    //private lateinit var progress: ProgressBar

    private var selectedTabIndex = 0
    private var categoryTabAdapter: CategoryTabAdapter? = null
    //todo add dual pane support
    private var isDualPane = false

    override fun layoutId() = R.layout.activity_main

    override fun pageTitle() = R.string.app_title

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getFeedCategories()
        }

        binding.apply {
            tabPager = categoryTabPager
            tabLayout = categoryTab
            //progress = progressBar
        }
    }

    override fun onData(data: Service?) {
        data?.workspace?.collections?.let { it ->
            categoryTabAdapter = CategoryTabAdapter(supportFragmentManager, it)
            tabPager.adapter = categoryTabAdapter

            tabLayout.setupWithViewPager(tabPager)
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    selectedTabIndex = tab?.position ?: 0

                    Log.d(TAG, "tab " + tab?.position)
                }
            })
        }
    }

    override fun onPrimaryAction(fragment: Fragment) {
        when (fragment) {
            is FeedListFragment -> {
                //start feed details activity
                Log.d(TAG, "onPrimary")
                feedEntryAction(fragment.categoryId, fragment.selectedFeedEntry.id)
            }
        }
    }

    private fun feedEntryAction(category: String, source: String) {
        if (isDualPane) {
            //todo show FeedDetailListFragment

        } else {
            start(FeedDetailListActivity::class.java, category, source)
        }
    }

    override fun performRefresh(force: Boolean) {
        Log.d(TAG, "performRefresh")
        categoryTabAdapter?.getSelectedFragment(selectedTabIndex)?.loadFeed(true)
    }

    /*override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }*/
}
