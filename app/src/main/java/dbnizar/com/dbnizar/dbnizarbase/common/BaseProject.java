package dbnizar.com.dbnizar.dbnizarbase.common;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import dbnizar.com.dbnizar.dbnizarbase.util.FontsOverride;


public class BaseProject extends Application {
    private static BaseProject mAppController;

    public static BaseProject getInstance() {
        return mAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppController = this;
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/gotham_light_0.otf");
    }


    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
