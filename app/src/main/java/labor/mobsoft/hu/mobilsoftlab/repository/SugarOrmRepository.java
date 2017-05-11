package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;
import android.util.Log;

import com.orm.SugarContext;
import com.orm.SugarRecord;
import com.orm.util.NamingHelper;

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

        List<Recipe> ownRecipes = SugarRecord.find(
                Recipe.class,
                NamingHelper.toSQLNameDefault("id") + " = ?", recipe.getId().toString()
        );

        if (ownRecipes.size() == 0) {
            recipe.save();
        }
    }

    @Override
    public void removeRecipe(Long id) {
        Recipe delRecipe = Recipe.findById(Recipe.class, id);
        delRecipe.delete();
        Recipe.executeQuery("DELETE FROM SQLITE_SEQUENCE WHERE NAME = 'RECIPE'");
    }

    @Override
    public void updateRecipe(Recipe newRecipe) {
        Recipe recipe = Recipe.findById(Recipe.class, newRecipe.getId());

        recipe.setDescription(newRecipe.getDescription());
        recipe.setTotalTime(newRecipe.getTotalTime());
        recipe.setTitle(newRecipe.getTitle());
        recipe.setDifficulty(newRecipe.getDifficulty());
        recipe.setIngredients(newRecipe.getIngredients());
        recipe.setImgUrl(newRecipe.getImgUrl());

        recipe.save();
        //SugarRecord.update(newRecipe);
    }

    @Override
    public void deleteAll() {
        Recipe.deleteAll(Recipe.class);
        Recipe.executeQuery("DELETE FROM SQLITE_SEQUENCE WHERE NAME = 'RECIPE'");
    }

    @Override
    public Recipe getRecipe(Long id) {

        return Recipe.findById(Recipe.class, id);
    }

}
