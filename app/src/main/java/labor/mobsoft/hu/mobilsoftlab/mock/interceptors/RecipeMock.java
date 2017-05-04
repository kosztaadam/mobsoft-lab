package labor.mobsoft.hu.mobilsoftlab.mock.interceptors;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import labor.mobsoft.hu.mobilsoftlab.repository.MemoryRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeMock implements RecipeApi {

    private MemoryRepository memoryRepository;

    @Override
    public Call<List<Recipe>> GetRecipes() {
        //final List<Recipe> recipeList = new ArrayList<>();
        //recipeList.add(new Recipe(1L, "Name", "Type", "Url", 1, "not recommended", "asd"));
        memoryRepository = new MemoryRepository();
        memoryRepository.open(null);

        Call<List<Recipe>> call = new Call<List<Recipe>>() {
            @Override
            public Response<List<Recipe>> execute() throws IOException {
                return Response.success(memoryRepository.getRecipes());
            }

            @Override
            public void enqueue(Callback<List<Recipe>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Recipe>> clone() {
                return null;
            }
        };

        return call;
    }
    
    
/*    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "todo/favourite") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;

            *//**
     * Simple Get Example
     *//*
            *//*
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*//*
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }*/
}
