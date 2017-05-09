package labor.mobsoft.hu.mobilsoftlab.ui;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public AddRecipePresenter provideAddRecipePresenter() {
        return new AddRecipePresenter();
    }

    @Provides
    @Singleton
    public EditRecipePresenter provideEditRecipePresenter() {
        return new EditRecipePresenter();
    }

    @Provides
    @Singleton
    public RecipeDetailsPresenter provideRecipeDeatilsPresenter() {
        return new RecipeDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }


}