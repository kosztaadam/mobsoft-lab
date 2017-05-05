package labor.mobsoft.hu.mobilsoftlab.ui.details;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface RecipeDetailsScreen {
    void showRecipeDetails(Recipe recipe);
    void deleteRecipe(Recipe recipe);
    void showError(String errorMessage);
}
