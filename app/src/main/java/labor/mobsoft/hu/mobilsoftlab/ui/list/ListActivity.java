package labor.mobsoft.hu.mobilsoftlab.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;

public class ListActivity extends AppCompatActivity implements ListScreen {

    @Inject
    ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }


    @Override
    public void showError(String text) {

    }

    @Override
    public void listRecipes() {

    }
}
