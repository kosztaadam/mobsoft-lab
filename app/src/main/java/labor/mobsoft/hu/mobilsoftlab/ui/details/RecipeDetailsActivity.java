package labor.mobsoft.hu.mobilsoftlab.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;

public class RecipeDetailsActivity extends AppCompatActivity implements RecipeDetailsScreen {

    @Inject
    Repository repository;

    TextView title;
    RatingBar ratingBar;
    TextView time;
    TextView description;
    TextView ingredients;
    ImageView image;

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

        Log.d("asd", "started detail, id:" + id.toString());

        recipeDeatilsPresenter.getRecipe(id);
    }


    @Override
    protected void onStop() {
        super.onStop();
        recipeDeatilsPresenter.detachScreen();
    }

    @Override
    public void showRecipeDetails(final Recipe recipe) throws MalformedURLException {

        Log.d("asd", "showrecipe, title: " + recipe.getTitle());

        title = (TextView) findViewById(R.id.tvTitle);
        title.setText(recipe.getTitle());

        ratingBar = (RatingBar) findViewById(R.id.ratingDifficult);
        ratingBar.setRating(recipe.getDifficulty());

        time = (TextView) findViewById(R.id.tvTime);
        time.setText(recipe.getTotalTime());

        description = (TextView) findViewById(R.id.tvDescription);
        description.setText(recipe.getDescription());

        ingredients = (TextView) findViewById(R.id.tvIngredients);
        ingredients.setText(recipe.getDescription());

        image = (ImageView) findViewById(R.id.recipeImage);
        String imageUrl = recipe.getImgUrl();
        Log.d("asd", "img url: " + recipe.getImgUrl());
        if (!imageUrl.isEmpty()) {
            Glide.with(this).load(recipe.getImgUrl()).into(image);
        }

        FloatingActionButton deleteBtn = (FloatingActionButton) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteRecipe(recipe);
            }
        });
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        repository.removeRecipe(recipe);
        startActivity(new Intent(this, ListActivity.class));
    }


    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
