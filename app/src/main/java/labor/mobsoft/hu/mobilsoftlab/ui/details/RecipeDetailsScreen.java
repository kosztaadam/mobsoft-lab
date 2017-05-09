package labor.mobsoft.hu.mobilsoftlab.ui.details;

import java.net.MalformedURLException;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface RecipeDetailsScreen {
    void showRecipeDetails(Recipe recipe) throws MalformedURLException;
    void deleteRecipe(Recipe recipe);
    void showError(String errorMessage);
    void listScreen();
    void editRecipe(Recipe recipe);
}
