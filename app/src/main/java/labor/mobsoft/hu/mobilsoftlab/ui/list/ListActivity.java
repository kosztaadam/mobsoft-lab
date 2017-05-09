package labor.mobsoft.hu.mobilsoftlab.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.adapter.RecipeAdapter;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeActivity;

public class ListActivity extends AppCompatActivity implements ListScreen {

    private RecyclerView recyclerViewRecipes;
    private SwipeRefreshLayout swipeRefreshLayoutRecipes;
    private TextView tvEmpty;
    private List<Recipe> recipeList;
    private RecipeAdapter recipeAdapter;

    @Inject
    ListPresenter listPresenter;

    @Inject
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MobSoftApplication.injector.inject(this);

        tvEmpty = (TextView) findViewById(R.id.recipes_tvEmpty);
        recyclerViewRecipes = (RecyclerView) findViewById(R.id.recipes_recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewRecipes.setLayoutManager(llm);

        recipeList = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(this, recipeList);
        recyclerViewRecipes.setAdapter(recipeAdapter);

        swipeRefreshLayoutRecipes = (SwipeRefreshLayout) findViewById(R.id.recipes_swipeRefreshLayout);
        swipeRefreshLayoutRecipes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listPresenter.refreshList();
            }
        });

        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.addRecipeBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addRecipe();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
        listPresenter.refreshList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }


    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void listRecipes(List<Recipe> recipes) {
        if (swipeRefreshLayoutRecipes != null) {
            swipeRefreshLayoutRecipes.setRefreshing(false);
        }

        if (recipes.isEmpty()) {
            recyclerViewRecipes.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerViewRecipes.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }

        this.recipeList.clear();
        this.recipeList.addAll(recipes);
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void addRecipe() {
        startActivity(new Intent(this, AddRecipeActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAll:
                repository.deleteAll();
                listPresenter.refreshList();
                recipeAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Saját receptek törölve!", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
