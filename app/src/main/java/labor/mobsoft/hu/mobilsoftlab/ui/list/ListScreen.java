package labor.mobsoft.hu.mobilsoftlab.ui.list;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface ListScreen {
    void showMessage(String text);
    void listRecipes(List<Recipe> recipes);
    void addRecipe();
}
