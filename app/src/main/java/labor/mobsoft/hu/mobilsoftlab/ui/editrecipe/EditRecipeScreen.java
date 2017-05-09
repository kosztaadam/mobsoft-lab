package labor.mobsoft.hu.mobilsoftlab.ui.editrecipe;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface EditRecipeScreen {
    void showRecipeDetails(Recipe recipe);
    void updateRecipe();
    void showMessage(String errorMessage);
}
