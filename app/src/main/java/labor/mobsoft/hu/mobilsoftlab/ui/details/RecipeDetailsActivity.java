package labor.mobsoft.hu.mobilsoftlab.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;

public class RecipeDetailsActivity extends AppCompatActivity implements RecipeDetailsScreen {

    @Inject
    RecipeDetailsPresenter recipeDeatilsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipeDeatilsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipeDeatilsPresenter.detachScreen();
    }

    @Override
    public void showRecipeDetails(String recipe) {

    }

    @Override
    public void updateRecipe(String recipe) {

    }

    @Override
    public void showError(String errorMessage) {

    }
}
