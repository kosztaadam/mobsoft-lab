package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Recipe> getRecipes();

    void addRecipe(Recipe recipe);

    void removeRecipe(Long id);

    void updateRecipe(Recipe recipe);

}