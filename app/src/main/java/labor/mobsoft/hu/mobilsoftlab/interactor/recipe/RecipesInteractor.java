package labor.mobsoft.hu.mobilsoftlab.interactor.recipe;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.login.event.GetUsersEvent;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.AddRecipeEvent;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipesEvent;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.model.User;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.RecipeApi;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeActivity;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public class RecipesInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    RecipeApi recipeApi;

    public RecipesInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void addRecipe(Recipe recipe) {
        AddRecipeEvent event = new AddRecipeEvent();
        event.setRecipe(recipe);
        try {
            repository.addRecipe(recipe);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }


    public void getRecipes() {
        Call<List<Recipe>> queryCall = recipeApi.GetRecipes();

        GetRecipesEvent event = new GetRecipesEvent();
        try {
            Response<List<Recipe>> response = queryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Something went wrong!");
            }
            event.setCode(response.code());
            List<Recipe> recipes = response.body();
            event.setRecipes(recipes);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
