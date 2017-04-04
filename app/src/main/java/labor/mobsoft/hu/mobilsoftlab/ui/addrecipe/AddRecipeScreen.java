package labor.mobsoft.hu.mobilsoftlab.ui.addrecipe;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface AddRecipeScreen {
    void showRecipeDetails(String recipe);
    void addRecipe(String recipe);
    void showError(String errorMessage);
}
