package labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

public class GetRecipeEvent {
    private int code;
    private Recipe recipe;
    private Throwable throwable;

    public GetRecipeEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
