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
import retrofit2.http.Body;
import retrofit2.http.Path;

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

    @Override
    public Call<Recipe> GetRecipe(final Long id) {
        memoryRepository = new MemoryRepository();
        memoryRepository.open(null);

        Call<Recipe> call = new Call<Recipe>() {
            @Override
            public Response<Recipe> execute() throws IOException {
                return Response.success(memoryRepository.getRecipe(id));
            }

            @Override
            public void enqueue(Callback<Recipe> callback) {

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
            public Call<Recipe> clone() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<List<Recipe>> recipePost(@Body Recipe body) {
        return null;
    }

    @Override
    public Call<List<Recipe>> DeleteRecipe(@Path("id") Long id) {
        return null;
    }

    @Override
    public Call<List<Recipe>> EditRecipe(@Body Recipe body) {
        return null;
    }

}
