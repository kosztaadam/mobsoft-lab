package labor.mobsoft.hu.mobilsoftlab.test;

import android.util.Log;

import com.orm.SugarRecord;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.net.MalformedURLException;
import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.BuildConfig;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipeScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListScreen;
import labor.mobsoft.hu.mobilsoftlab.utils.RobolectricDaggerTestRunner;

import static junit.framework.Assert.assertTrue;
import static labor.mobsoft.hu.mobilsoftlab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Koszta Ádám on 2017. 05. 12..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DetailRecipeTest {

    private RecipeDetailsPresenter recipeDetailsPresenter;
    private RecipeDetailsScreen recipeDetailsScreen;

    private ListPresenter listPresenter;
    private ListScreen listScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        recipeDetailsPresenter = new RecipeDetailsPresenter();
        recipeDetailsScreen = mock(RecipeDetailsScreen.class);
        recipeDetailsPresenter.attachScreen(recipeDetailsScreen);

        listPresenter = new ListPresenter();
        listScreen = mock(ListScreen.class);
        listPresenter.attachScreen(listScreen);

        listPresenter.refreshList();
    }

    @Test
    public void detailRecipe1() throws MalformedURLException {

        recipeDetailsPresenter.getRecipe(1L);

        ArgumentCaptor<Recipe> userCaptor = ArgumentCaptor.forClass(Recipe.class);
        verify(recipeDetailsScreen, times(1)).showRecipeDetails(userCaptor.capture());

        Recipe capturedRecipe = userCaptor.getValue();
        assertEquals("Paprikas krumpli", capturedRecipe.getTitle());
    }

    @Test
    public void detailRecipe2() throws MalformedURLException {

        recipeDetailsPresenter.getRecipe(2L);

        ArgumentCaptor<Recipe> userCaptor = ArgumentCaptor.forClass(Recipe.class);
        verify(recipeDetailsScreen, times(1)).showRecipeDetails(userCaptor.capture());

        Recipe capturedRecipe = userCaptor.getValue();
        assertEquals("Husleves", capturedRecipe.getTitle());
    }


    @After
    public void tearDown() {
        recipeDetailsPresenter.detachScreen();
        listPresenter.detachScreen();
    }

}