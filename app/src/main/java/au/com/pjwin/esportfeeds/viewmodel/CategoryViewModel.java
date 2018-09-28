package au.com.pjwin.esportfeeds.viewmodel;

import au.com.pjwin.commonlib.viewmodel.retrofit.RetrofitDataViewModel;
import au.com.pjwin.esportfeeds.model.Service;
import au.com.pjwin.esportfeeds.repo.retrofit.AppRepo;

public class CategoryViewModel extends RetrofitDataViewModel<Service> {

    public void getFeedCategories() {
        enqueue(AppRepo.feedService().getRootService(),
                service -> {
                    onData(service);
                    return null;//kotlin compatibility
                });
    }
}
