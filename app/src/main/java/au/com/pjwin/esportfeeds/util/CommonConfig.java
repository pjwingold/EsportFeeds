package au.com.pjwin.esportfeeds.util;

import android.os.Build;

import org.jetbrains.annotations.NotNull;

import au.com.pjwin.commonlib.Common;
import au.com.pjwin.esportfeeds.BuildConfig;
import au.com.pjwin.esportfeeds.R;

public class CommonConfig implements Common.Config {

    @NotNull
    @Override
    public String schema() {
        return BuildConfig.SCHEMA;
    }

    @NotNull
    @Override
    public String host() {
        return BuildConfig.HOST;
    }

    @Override
    public int port() {
        return BuildConfig.PORT;
    }

    @NotNull
    @Override
    public String contextRoot() {
        return BuildConfig.CONTEXT_ROOT;
    }

    @Override
    public long readTimeout() {
        return BuildConfig.READ_TIMEOUT;
    }

    @Override
    public long connectionTimeout() {
        return BuildConfig.CONNECTION_TIMEOUT;
    }

    @Override
    public boolean debug() {
        return BuildConfig.DEBUG;
    }

    @NotNull
    @Override
    public String credentialBase64() {
        return "";
    }

    @NotNull
    @Override
    public String acceptHeader() {
        return "";
    }

    @NotNull
    @Override
    public String sourceDateFormat() {
        //2018-09-22T23:52:16.290+00:00
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.M ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    }

    @Override
    public int launcherIcon() {
        return R.mipmap.ic_launcher;
    }
}
