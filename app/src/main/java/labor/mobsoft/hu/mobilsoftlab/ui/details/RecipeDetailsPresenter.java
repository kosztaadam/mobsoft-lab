package labor.mobsoft.hu.mobilsoftlab.ui.details;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.net.MalformedURLException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipeEvent;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.RemoveRecipeEvent;
import labor.mobsoft.hu.mobilsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class RecipeDetailsPresenter extends Presenter<RecipeDetailsScreen> {

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public RecipeDetailsPresenter() {
    }

    @Override
    public void attachScreen(RecipeDetailsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
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
                screen.showError("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                Log.d("asd", event.getRecipe().getTitle());
                screen.showRecipeDetails(event.getRecipe());
                screen.showError(event.getRecipe().getTitle());
            }
        }
    }

    public void removeRecipe(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.removeRecipe(id);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(RemoveRecipeEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                screen.listScreen();
                screen.showError("Elem sikeresen torolve!");
            }
        }
    }
}