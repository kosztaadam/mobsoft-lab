package labor.mobsoft.hu.mobilsoftlab.utils;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private static Gson gson;

    static {
        gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
    }

    public static Gson getGson() {
        return gson;
    }
}
