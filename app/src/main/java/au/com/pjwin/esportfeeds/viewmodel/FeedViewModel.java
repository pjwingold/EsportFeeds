package au.com.pjwin.esportfeeds.viewmodel;

import au.com.pjwin.commonlib.viewmodel.retrofit.RetrofitDataViewModel;
import au.com.pjwin.esportfeeds.model.FeedResponse;
import au.com.pjwin.esportfeeds.repo.retrofit.AppRepo;

public class FeedViewModel extends RetrofitDataViewModel<FeedResponse> {

    public void getFeedByCategory(String category, boolean force) {
        enqueue(AppRepo.feedService().getFeedsByCategory(category, force),
                feedResponse -> {
                    onData(feedResponse);
                    return null;
                }, !force);//only show the swipe refresh progress instead of the one in the page
    }

    public void getFeedDetails(String category, String source, boolean force) {
        enqueue(AppRepo.feedService().getFeedEntryDetails(category, source, force),
                feedResponse -> {
                    onData(feedResponse);
                    return null;
                }, !force);
    }
}
