package au.com.pjwin.esportfeeds;

import au.com.pjwin.commonlib.Common;
import au.com.pjwin.esportfeeds.util.CommonConfig;

public class TestFeedApp extends ESportFeedApp {

    @Override
    protected void initCommon() {
        Common.init(getApplicationContext(), new CommonConfig(), true);
    }
}
