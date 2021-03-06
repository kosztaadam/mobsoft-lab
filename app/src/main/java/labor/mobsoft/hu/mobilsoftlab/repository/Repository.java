package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.model.User;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Recipe> getRecipes();

    List<User> getUsers();

    Recipe getRecipe(Long id);

    void addRecipe(Recipe recipe);

    void removeRecipe(Long id);

    void updateRecipe(Recipe recipe);

    void deleteAll();

}