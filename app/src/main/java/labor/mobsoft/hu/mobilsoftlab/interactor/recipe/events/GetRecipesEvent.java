package labor.mobsoft.hu.mobilsoftlab.interactor.recipe.events;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;

/**
 * Created by Koszta Ádám on 2017. 04. 18..
 */

public class GetRecipesEvent {
    private int code;
    private List<Recipe> recipes;
    private Throwable throwable;

    public GetRecipesEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }


}
