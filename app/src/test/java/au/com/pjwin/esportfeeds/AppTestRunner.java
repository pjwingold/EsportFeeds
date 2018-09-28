package au.com.pjwin.esportfeeds;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;

public class AppTestRunner extends RobolectricTestRunner {
    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */
    public AppTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }
}
