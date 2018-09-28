package au.com.pjwin.esportfeeds.viewmodel;

import org.junit.Test;
import org.mockito.Spy;

import au.com.pjwin.esportfeeds.BaseTest;

public class TestFeedViewModel extends BaseTest {

    @Spy
    private CategoryViewModel categoryViewModel;

    @Spy
    private FeedViewModel feedViewModel;

    @Test
    public void testGetFeedCategories() {
        categoryViewModel.getFeedCategories();
    }

    @Test
    public void testGetFeedByCategoryDota() {
        feedViewModel.getFeedByCategory("dota2", false);
    }

    @Test
    public void testGetFeedDetails() {
        feedViewModel.getFeedDetails("dota2", "dota2blog", false);
    }
}
