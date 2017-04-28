package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class MemoryRepository implements Repository {

    public static List<Recipe> recipes;

    @Override
    public void open(Context context) {
        Recipe recipe1 = new Recipe(1L, "Paprikas krumpli", "img", "30 perc", 3, "krumpli, pirospaprika", "Tegyuk egy labasba a krumplit...");
        Recipe recipe2 = new Recipe(2L, "Husleves", "img2", "60 perc", 3, "hus, leveskocka, so, bors", "Tegyuk egy labasba a hust...");

        recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        for (int i = 0; i < this.recipes.size(); i++) {
            for (Recipe item : recipes) {
                if (item.getId().equals(recipe.getId())) {
                    this.recipes.set(i, item);
                }
            }
        }
    }

}
