package labor.mobsoft.hu.mobilsoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

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
        return SugarRecord.listAll(Recipe.class);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        //SugarRecord.saveInTx(recipe);
        recipe.save();
    }

    @Override
    public void removeRecipe(Long id) {
        //SugarRecord.deleteInTx(id);
        Recipe recipe = Recipe.findById(Recipe.class, 1);
        recipe.delete();
    }

    @Override
    public void updateRecipe(Recipe newRecipe) {
        Recipe recipe = Recipe.findById(Recipe.class, 1);
        recipe.setDescription(newRecipe.getDescription());
        recipe.save(); // updates the previous entry with new values.
    }

}