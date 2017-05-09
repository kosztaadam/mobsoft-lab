package labor.mobsoft.hu.mobilsoftlab.mock.interceptors;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.io.IOException;
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

    public RecipeMock() {
        memoryRepository = new MemoryRepository();
        memoryRepository.open(null);
    }

    @Override
    public Call<List<Recipe>> GetRecipes() {

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
    public Call<List<Recipe>> removeRecipe(@Path("id") final Long id) {

        Call<List<Recipe>> call = new Call<List<Recipe>>() {

            @Override
            public Response<List<Recipe>> execute() throws IOException {
                memoryRepository.removeRecipe(id);
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
    public Call<List<Recipe>> editRecipe(@Body final Recipe body) {

        Call<List<Recipe>> call = new Call<List<Recipe>>() {

            @Override
            public Response<List<Recipe>> execute() throws IOException {
                memoryRepository.updateRecipe(body);
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

}
