package labor.mobsoft.hu.mobilsoftlab.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

public class RecipeDetailsActivity extends AppCompatActivity implements RecipeDetailsScreen {

    TextView title;
    TextView description;
    TextView count;

    @Inject
    RecipeDetailsPresenter recipeDeatilsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipeDeatilsPresenter.attachScreen(this);

        Bundle intentExtras = getIntent().getExtras();
        Long id = Long.parseLong(intentExtras.getString("id"));

        recipeDeatilsPresenter.getRecipe(id);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipeDeatilsPresenter.detachScreen();
    }

    @Override
    public void showRecipeDetails(Recipe recipe) {

        title = (TextView) findViewById(R.id.cardrecipe_tvType);
        title.setText(recipe.getTitle());

        description = (TextView) findViewById(R.id.cardrecipe_tvName);
        description.setText(recipe.getId().toString());

        count = (TextView) findViewById(R.id.cardrecipe_tvCount);
        description.setText(recipe.getDescription());
    }

    @Override
    public void deleteRecipe(Recipe recipe) {

    }


    @Override
    public void showError(String errorMessage) {

    }
}
