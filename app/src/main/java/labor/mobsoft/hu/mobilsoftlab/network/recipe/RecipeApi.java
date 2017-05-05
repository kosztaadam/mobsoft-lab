package labor.mobsoft.hu.mobilsoftlab.network.recipe;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;


public interface RecipeApi {

    @GET("recipes")
    Call<List<Recipe>> GetRecipes();

    @GET("recipe/{id}")
    Call<Recipe> GetRecipe(Long id);

}