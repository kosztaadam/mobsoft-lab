package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.model.User;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Recipe> getRecipes() {
        return Recipe.listAll(Recipe.class);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipe.save();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        //SugarRecord.deleteInTx(id);
        Recipe delRecipe = Recipe.findById(Recipe.class, recipe.getId());
        delRecipe.delete();
    }

    @Override
    public void updateRecipe(Recipe newRecipe) {
        //Recipe recipe = Recipe.findById(Recipe.class, newRecipe.getId());
        //recipe.setDescription(newRecipe.getDescription());
        // recipe.save(); // updates the previous entry with new values.
        //SugarRecord.update(newRecipe);
    }

    @Override
    public void deleteAll() {
        Recipe.deleteAll(Recipe.class);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return Recipe.findById(Recipe.class, id);
    }

}
