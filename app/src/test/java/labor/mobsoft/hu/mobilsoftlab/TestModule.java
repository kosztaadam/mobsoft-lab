package labor.mobsoft.hu.mobilsoftlab;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.ui.UIModule;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainPresenter;
import labor.mobsoft.hu.mobilsoftlab.utils.UiExecutor;

/**
 * Created by Koszta Ádám on 2017. 05. 09..
 */

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public ListPresenter provideListPresenter() {
        return UIModule.provideListPresenter();
    }

    @Provides
    public EditRecipePresenter provideEditRecipePresenter() {
        return UIModule.provideEditRecipePresenter();
    }


    @Provides
    public AddRecipePresenter provideAddRecipePresenter() {
        return UIModule.provideAddRecipePresenter();
    }


    @Provides
    public RecipeDetailsPresenter provideRecipeDetailsPresenter() {
        return UIModule.provideRecipeDeatilsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}
