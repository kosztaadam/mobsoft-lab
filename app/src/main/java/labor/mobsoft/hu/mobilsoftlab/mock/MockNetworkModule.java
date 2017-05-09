package labor.mobsoft.hu.mobilsoftlab.mock;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.mock.interceptors.RecipeMock;
import labor.mobsoft.hu.mobilsoftlab.mock.interceptors.UserMock;
import labor.mobsoft.hu.mobilsoftlab.network.NetworkConfig;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.LoginApi;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
/*
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
*/

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
