package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.model.User;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class MemoryRepository implements Repository {

    public static List<Recipe> recipes;
    public static List<User> users;

    @Override
    public void open(Context context) {
        Recipe recipe1 = new Recipe(1L, "Paprikas krumpli", "http://www.mindmegette.hu/images/16/O/23936_kolbaszos-paprikas-krumpli_n-201510170539.jpg", "30 perc", 3, "krumpli, pirospaprika", "Tegyuk egy labasba a krumplit...");
        Recipe recipe2 = new Recipe(2L, "Husleves", "http://www.men.hu/wp-content/uploads/2013/03/485_bigger.jpg", "60 perc", 2, "hus, leveskocka, so, bors", "Tegyuk egy labasba a hust...");

        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        User user1 = new User(1L, "bela");
        User user2 = new User(2L, "adam");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public Recipe getRecipe(Long id) {
        for (Recipe item : recipes) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        Recipe recipe = new Recipe();
        recipe.setId(id);
        return recipe;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public void removeRecipe(Long id) {

        for (Recipe item : recipes) {
            if (item.getId() == id)
                recipes.remove(item);
        }
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            for (Recipe item : recipes) {
                if (item.getId().equals(recipe.getId())) {
                    recipes.set(i, item);
                }
            }
        }
    }

    @Override
    public void deleteAll() {
        recipes.clear();
    }

}
