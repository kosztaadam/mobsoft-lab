package labor.mobsoft.hu.mobilsoftlab.ui.list;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events.GetRecipesEvent;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class ListPresenter extends Presenter<ListScreen> {

    @Inject
    RecipesInteractor recipesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void refreshList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                recipesInteractor.getRecipes();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(GetRecipesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading recipes", event.getThrowable());
        } else {
            if (screen != null) {
                screen.listRecipes(event.getRecipes());
                for(Recipe r : event.getRecipes()) {
                    screen.showMessage(r.getTitle());
                }
            }
        }
    }
}