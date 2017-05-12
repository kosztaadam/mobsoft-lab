package labor.mobsoft.hu.mobilsoftlab.mock;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.mock.interceptors.RecipeMock;
import labor.mobsoft.hu.mobilsoftlab.mock.interceptors.UserMock;
import labor.mobsoft.hu.mobilsoftlab.network.NetworkConfig;
import labor.mobsoft.hu.mobilsoftlab.network.NetworkModule;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.LoginApi;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
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
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.SERVICE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public RecipeApi provideRecipeApi(Retrofit retrofit) {
        return new RecipeMock();
    }

    @Provides
    @Singleton
    public LoginApi provideLoginApi(Retrofit retrofit) {
        return new UserMock();
    }
}
