package labor.mobsoft.hu.mobilsoftlab.interactor.recipe;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;

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



}
