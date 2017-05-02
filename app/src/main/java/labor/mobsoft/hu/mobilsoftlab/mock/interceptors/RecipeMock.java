package labor.mobsoft.hu.mobilsoftlab.mock.interceptors;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import labor.mobsoft.hu.mobilsoftlab.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import android.net.Uri;

import static labor.mobsoft.hu.mobilsoftlab.mock.interceptors.MockHelper.makeResponse;

public class RecipeMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "todo/favourite") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;

            /**
             * Simple Get Example
             */
			/*
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*/
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
