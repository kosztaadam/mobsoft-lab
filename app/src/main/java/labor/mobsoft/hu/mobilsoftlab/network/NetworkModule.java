package labor.mobsoft.hu.mobilsoftlab.network;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import labor.mobsoft.hu.mobilsoftlab.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public RecipeApi provideATodoApi(Retrofit retrofit) {
        return retrofit.create(RecipeApi.class);
    }

}

