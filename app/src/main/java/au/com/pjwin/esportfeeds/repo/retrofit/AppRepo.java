package au.com.pjwin.esportfeeds.repo.retrofit;

import au.com.pjwin.commonlib.repo.retrofit.RetrofitRepo;

public class AppRepo {
    public static FeedService feedService() {
        return RetrofitRepo.getRETROFIT_OPEN_AUTH_XML().create(FeedService.class);
    }
}
