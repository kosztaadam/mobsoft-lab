package labor.mobsoft.hu.mobilsoftlab.mock.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}

    /*
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "todo")) {
            return RecipeMock.GetRecipes();
        }

        return makeResponse(request, headers, 404, "Unknown");

    }

}
*/