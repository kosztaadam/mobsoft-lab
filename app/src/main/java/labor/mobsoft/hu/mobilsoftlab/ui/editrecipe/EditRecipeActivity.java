package labor.mobsoft.hu.mobilsoftlab.ui.editrecipe;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;

public class EditRecipeActivity extends AppCompatActivity implements EditRecipeScreen {

    private Button editBtn, cancelBtn;
    private EditText etTitle;
    private EditText etImgUrl;
    private EditText etTotalTime;
    private EditText etIngredients;
    private EditText etDescription;
    private RatingBar ratingBar;

    @Inject
    EditRecipePresenter editRecipePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        MobSoftApplication.injector.inject(this);

        editBtn = (Button) findViewById(R.id.editrecipe_btnSave);
        cancelBtn = (Button) findViewById(R.id.editrecipe_btnCancel);

        etTitle = (EditText) findViewById(R.id.editrecipe_etTitle);
        etImgUrl = (EditText) findViewById(R.id.editrecipe_etImgUrl);
        etTotalTime = (EditText) findViewById(R.id.editrecipe_etTotalTime);
        etIngredients = (EditText) findViewById(R.id.editrecipe_etIngredients);
        etDescription = (EditText) findViewById(R.id.editrecipe_etDescription);
        ratingBar = (RatingBar) findViewById(R.id.editrecipe_rating);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);

    }

    @Override
    protected void onStart() {
        super.onStart();
        editRecipePresenter.attachScreen(this);

        Bundle intentExtras = getIntent().getExtras();
        final Long id = Long.parseLong(intentExtras.getString("id"));

        editRecipePresenter.getRecipe(id);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new Recipe();
                recipe.setTitle(etTitle.getText().toString());
                recipe.setTotalTime(etTotalTime.getText().toString());
                recipe.setDescription(etDescription.getText().toString());
                recipe.setImgUrl(etImgUrl.getText().toString());
                recipe.setIngredients(etIngredients.getText().toString());
                recipe.setDifficulty((int) ratingBar.getRating());
                recipe.setId(id);

                editRecipePresenter.editRecipe(recipe);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditRecipeActivity.this, ListActivity.class));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        editRecipePresenter.detachScreen();
    }

    @Override
    public void showRecipeDetails(Recipe recipe) {
        etTitle.setText(recipe.getTitle());
        etImgUrl.setText(recipe.getImgUrl());
        etTotalTime.setText(recipe.getTotalTime());
        etIngredients.setText(recipe.getIngredients());
        etDescription.setText(recipe.getDescription());
        ratingBar.setRating(recipe.getDifficulty());
    }

    @Override
    public void updateRecipe() {
        startActivity(new Intent(EditRecipeActivity.this, ListActivity.class));
    }

    @Override
    public void showMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

}
