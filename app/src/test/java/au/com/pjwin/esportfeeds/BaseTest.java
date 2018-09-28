package au.com.pjwin.esportfeeds;

import android.support.annotation.CallSuper;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

@RunWith(AppTestRunner.class)
@Config(constants = BuildConfig.class, application = TestFeedApp.class)
public class BaseTest {

    @CallSuper
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
