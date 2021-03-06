package labor.mobsoft.hu.mobilsoftlab.ui.editrecipe;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.net.MalformedURLException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.EditRecipeEvent;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipeEvent;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class EditRecipePresenter extends Presenter<EditRecipeScreen> {

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public EditRecipePresenter() {
    }

    @Override
    public void attachScreen(EditRecipeScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void editRecipe(final Recipe recipe) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.editRecipe(recipe);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EditRecipeEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showMessage("Elem sikeresen módosítva!");
                screen.updateRecipe();
            }
        }
    }

    public void getRecipe(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.getRecipe(id);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(GetRecipeEvent event) throws MalformedURLException {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showRecipeDetails(event.getRecipe());
            }
        }
    }
}