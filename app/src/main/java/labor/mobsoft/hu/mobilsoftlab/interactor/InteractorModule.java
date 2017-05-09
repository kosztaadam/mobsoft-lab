package labor.mobsoft.hu.mobilsoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import labor.mobsoft.hu.mobilsoftlab.interactor.login.LoginInteractor;
import labor.mobsoft.hu.mobilsoftlab.interactor.recipe.RecipesInteractor;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

@Module
public class InteractorModule {

    @Provides
    public RecipesInteractor provideRecipesInteractor() {
        return new RecipesInteractor();
    }

    @Provides
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractor();
    }

}

