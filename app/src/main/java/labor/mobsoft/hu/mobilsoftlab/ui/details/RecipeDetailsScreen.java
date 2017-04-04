package labor.mobsoft.hu.mobilsoftlab.ui.details;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface RecipeDetailsScreen {
    void showRecipeDetails(String recipe);
    void deleteRecipe(String recipe);
    void showError(String errorMessage);
}
