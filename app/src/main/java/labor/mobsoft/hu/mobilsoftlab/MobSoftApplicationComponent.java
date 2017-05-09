package labor.mobsoft.hu.mobilsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import labor.mobsoft.hu.mobilsoftlab.interactor.InteractorModule;
import labor.mobsoft.hu.mobilsoftlab.interactor.login.LoginInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.mock.MockNetworkModule;
import labor.mobsoft.hu.mobilsoftlab.repository.RepositoryModule;
import labor.mobsoft.hu.mobilsoftlab.ui.UIModule;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipeActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(ListActivity listActivity);

    void inject(ListPresenter listPresenter);

    void inject(AddRecipeActivity addRecipeActivity);

    void inject(AddRecipePresenter addRecipePresenter);

    void inject(EditRecipeActivity editRecipeActivity);

    void inject(RecipeDetailsActivity recipeDetailsActivity);

    void inject(RecipeDetailsPresenter recipeDetailsPresenter);

    void inject(RecipesInteractor recipesInteractor);

    void inject(LoginInteractor loginInteractor);

    void inject(MobSoftApplication mobSoftApplication);
}
