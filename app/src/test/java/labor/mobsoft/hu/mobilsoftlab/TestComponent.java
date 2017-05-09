package labor.mobsoft.hu.mobilsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import labor.mobsoft.hu.mobilsoftlab.interactor.InteractorModule;
import labor.mobsoft.hu.mobilsoftlab.mock.MockNetworkModule;
import labor.mobsoft.hu.mobilsoftlab.repository.TestRepositoryModule;

/**
 * Created by Koszta Ádám on 2017. 05. 09..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
