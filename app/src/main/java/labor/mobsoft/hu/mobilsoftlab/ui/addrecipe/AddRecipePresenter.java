package labor.mobsoft.hu.mobilsoftlab.ui.addrecipe;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipesEvent;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AddRecipePresenter extends Presenter<AddRecipeScreen> {

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(AddRecipeScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void addRecipe() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.addRecipe();
            }
        });
    }

    public void onEventMainThread(GetRecipesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                for(Recipe r : event.getRecipes()){
                    screen.showMessage(r.getTitle());;
                }
            }
        }
    }
}