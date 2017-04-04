package labor.mobsoft.hu.mobilsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import labor.mobsoft.hu.mobilsoftlab.ui.UIModule;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ListActivity listActivity);

}
