package labor.mobsoft.hu.mobilsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import labor.mobsoft.hu.mobilsoftlab.interactor.InteractorModule;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;
import labor.mobsoft.hu.mobilsoftlab.network.NetworkModule;
import labor.mobsoft.hu.mobilsoftlab.repository.RepositoryModule;
import labor.mobsoft.hu.mobilsoftlab.ui.UIModule;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipeActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ListActivity listActivity);
    void inject(AddRecipeActivity addRecipeActivity);
    void inject(EditRecipeActivity editRecipeActivity);
    void inject(RecipeDetailsActivity recipeDetailsActivity);

    void inject(RecipesInteractor recipesInteractor);
    void inject(MobSoftApplication mobSoftApplication);
}
