package labor.mobsoft.hu.mobilsoftlab.mock;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.network.NetworkModule;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public RecipeApi provideAuthApi(Retrofit retrofit) {
        return networkModule.provideATodoApi(retrofit);
    }
}
