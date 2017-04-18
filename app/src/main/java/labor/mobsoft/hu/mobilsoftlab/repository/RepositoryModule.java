package labor.mobsoft.hu.mobilsoftlab.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}

