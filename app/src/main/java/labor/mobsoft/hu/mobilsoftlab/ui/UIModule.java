package labor.mobsoft.hu.mobilsoftlab.ui;

import android.content.Context;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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

}