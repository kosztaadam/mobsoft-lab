package labor.mobsoft.hu.mobilsoftlab.ui.addrecipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;

public class AddRecipeActivity extends AppCompatActivity implements AddRecipeScreen {

    @Inject
    AddRecipePresenter addRecipePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addRecipePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        addRecipePresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
