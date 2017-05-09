package labor.mobsoft.hu.mobilsoftlab.ui.addrecipe;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface AddRecipeScreen {
    void addRecipe(Recipe recipe);
    void showMessage(String errorMessage);
}
