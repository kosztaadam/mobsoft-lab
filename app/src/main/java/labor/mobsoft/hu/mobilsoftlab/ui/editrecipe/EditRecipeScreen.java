package labor.mobsoft.hu.mobilsoftlab.ui.editrecipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface EditRecipeScreen {
    void showRecipeDetails(String recipe);
    void updateRecipe(String recipe);
    void showError(String errorMessage);
}
