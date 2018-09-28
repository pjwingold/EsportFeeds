package au.com.pjwin.esportfeeds.repo.retrofit;

import au.com.pjwin.esportfeeds.BuildConfig;
import au.com.pjwin.esportfeeds.model.FeedResponse;
import au.com.pjwin.esportfeeds.model.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface FeedService {

    int apiVersion = BuildConfig.API_VERSION;

    @Headers("cache: true")
    @GET("sports?v=" + apiVersion)
    Call<Service> getRootService();

    @Headers("cache: true")
    @GET("sports/{category}?v=" + apiVersion)
    Call<FeedResponse> getFeedsByCategory(@Path("category") String category,
                                          @Header("refresh") boolean... refresh);

    @Headers("cache: true")
    @GET("sports/{category}/{source}?v=" + apiVersion)
    Call<FeedResponse> getFeedEntryDetails(@Path("category") String category,
                                           @Path("source") String source,
                                           @Header("refresh") boolean... refresh);
}
