package labor.mobsoft.hu.mobilsoftlab.network.recipe;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface RecipeApi {

    /**
     * Get all recipes
     * @return Call<List<Recipe>>
     */

    @GET("recipes")
    Call<List<Recipe>> GetRecipes();

    /**
     * Get a recipe
     * Get a recipe
     * @return Call<List<Recipe>>
     */

    @GET("recipes/{id}")
    Call<Recipe> GetRecipe(
            @Path("id") Long id
    );

    /**
     * Add a new recipe
     * @return Call<List<Recipe>>
     */

    @POST("recipe")
    Call<List<Recipe>> recipePost(
            @Body Recipe body
    );

    /**
     * Delete a recipe
     * @return Call<List<Recipe>>
     */

    @DELETE("recipe/delete/{id}")
    Call<List<Recipe>> removeRecipe(
            @Path("id") Long id
    );

    /**
     * Edit a recipe
     * Edit a recipe
     * @return Call<List<Recipe>>
     */

    @POST("recipe/edit")
    Call<List<Recipe>> editRecipe(
            @Body Recipe body
    );

}