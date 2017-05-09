package labor.mobsoft.hu.mobilsoftlab.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipeActivity;
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

        recipeDeatilsPresenter.getRecipe(id);
    }


    @Override
    protected void onStop() {
        super.onStop();
        recipeDeatilsPresenter.detachScreen();
    }

    @Override
    public void showRecipeDetails(final Recipe recipe) throws MalformedURLException {

        title = (TextView) findViewById(R.id.tvTitle);
        title.setText(recipe.getTitle());

        ratingBar = (RatingBar) findViewById(R.id.ratingDifficult);
        ratingBar.setRating(recipe.getDifficulty());

        time = (TextView) findViewById(R.id.tvTime);
        time.setText(recipe.getTotalTime());

        description = (TextView) findViewById(R.id.tvDescription);
        description.setText(recipe.getDescription());

        ingredients = (TextView) findViewById(R.id.tvIngredients);
        ingredients.setText(recipe.getIngredients());

        image = (ImageView) findViewById(R.id.recipeImage);
        String imageUrl = recipe.getImgUrl();
        if (!imageUrl.isEmpty()) {
            Glide.with(this).load(recipe.getImgUrl()).into(image);
        }

        FloatingActionButton deleteBtn = (FloatingActionButton) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteRecipe(recipe);
            }
        });

        FloatingActionButton editBtn = (FloatingActionButton) findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editRecipe(recipe);
            }
        });
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeDeatilsPresenter.removeRecipe(recipe.getId());
    }


    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void listScreen() {
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    public void editRecipe(Recipe recipe) {
        Intent intent = new Intent(this, EditRecipeActivity.class);
        intent.putExtra("id", recipe.getId().toString());
        startActivity(intent);
    }
}
