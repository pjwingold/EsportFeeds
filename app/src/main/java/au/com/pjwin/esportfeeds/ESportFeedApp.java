package au.com.pjwin.esportfeeds;

import android.app.Application;

import au.com.pjwin.commonlib.Common;
import au.com.pjwin.esportfeeds.util.CommonConfig;

public class ESportFeedApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initCommon();
    }

    protected void initCommon() {
        Common.init(getApplicationContext(), new CommonConfig(), false);
    }
}
