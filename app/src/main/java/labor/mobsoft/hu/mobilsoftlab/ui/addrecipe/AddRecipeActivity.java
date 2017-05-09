package labor.mobsoft.hu.mobilsoftlab.ui.addrecipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

public class AddRecipeActivity extends AppCompatActivity implements AddRecipeScreen {

    private Button addBtn, cancelBtn;
    private EditText etTitle;
    private EditText etImgUrl;
    private EditText etTotalTime;
    private EditText etIngredients;
    private EditText etDescription;
    private RatingBar ratingBar;


    @Inject
    AddRecipePresenter addRecipePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newrecipe);

        MobSoftApplication.injector.inject(this);

        addBtn = (Button) findViewById(R.id.newrecipe_btnSave);
        cancelBtn = (Button) findViewById(R.id.newrecipe_btnCancel);

        etTitle = (EditText) findViewById(R.id.newrecipe_etTitle);
        etImgUrl = (EditText) findViewById(R.id.newrecipe_etImgUrl);
        etTotalTime = (EditText) findViewById(R.id.newrecipe_etTotalTime);
        etIngredients = (EditText) findViewById(R.id.newrecipe_etIngredients);
        etDescription = (EditText) findViewById(R.id.newrecipe_etDescription);
        ratingBar = (RatingBar) findViewById(R.id.newrecipe_rating);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new Recipe();
                recipe.setTitle(etTitle.getText().toString());
                recipe.setDescription(etDescription.getText().toString());
                recipe.setImgUrl(etImgUrl.getText().toString());
                recipe.setIngredients(etIngredients.getText().toString());
                recipe.setDifficulty(ratingBar.getNumStars());

                addRecipe(recipe);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public void showMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
