package labor.mobsoft.hu.mobilsoftlab.interactor.recipe;


import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipesEvent;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeActivity;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public class RecipesInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public RecipesInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void addRecipe() {
    }

    public void getRecipes() {
        GetRecipesEvent event = new GetRecipesEvent();
        try {
            List<Recipe> recipes = repository.getRecipes();
            event.setRecipes(recipes);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
