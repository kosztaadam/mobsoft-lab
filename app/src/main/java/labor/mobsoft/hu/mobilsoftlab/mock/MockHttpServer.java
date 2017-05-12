package labor.mobsoft.hu.mobilsoftlab.mock;

import labor.mobsoft.hu.mobilsoftlab.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        //return mockInterceptor.process(request);
        return null;
    }
}
