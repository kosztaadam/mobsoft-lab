package labor.mobsoft.hu.mobilsoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.BuildConfig;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.addrecipe.AddRecipeScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipePresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.editrecipe.EditRecipeScreen;
import labor.mobsoft.hu.mobilsoftlab.utils.RobolectricDaggerTestRunner;

import static labor.mobsoft.hu.mobilsoftlab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by koszt on 2017. 05. 11..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddEditRemoveRecipeTest {

    private AddRecipePresenter addRecipePresenter;
    private AddRecipeScreen addRecipeScreen;
    private RecipeDetailsPresenter recipeDetailsPresenter;
    private RecipeDetailsScreen recipeDetailsScreen;
    private EditRecipePresenter editRecipePresenter;
    private EditRecipeScreen editRecipeScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        addRecipePresenter = new AddRecipePresenter();
        recipeDetailsPresenter = new RecipeDetailsPresenter();
        editRecipePresenter = new EditRecipePresenter();

        addRecipeScreen = mock(AddRecipeScreen.class);
        addRecipePresenter.attachScreen(addRecipeScreen);

        recipeDetailsScreen = mock(RecipeDetailsScreen.class);
        recipeDetailsPresenter.attachScreen(recipeDetailsScreen);

        editRecipeScreen = mock(EditRecipeScreen.class);
        editRecipePresenter.attachScreen(editRecipeScreen);
    }

    @Test
    public void addRecipeTest() {

        Recipe recipe = new Recipe(1L, "Halaszle", "", "1 ora", 2, "hal, pirospaprika", "Pucoljuk meg a halat...");

        addRecipePresenter.addRecipe(recipe);

        ArgumentCaptor<String> userCaptor = ArgumentCaptor.forClass(String.class);
        verify(addRecipeScreen, times(1)).showMessage(userCaptor.capture());

        List<String> capturedText = userCaptor.getAllValues();
        assertEquals("Elem sikeresen hozzáadva!", capturedText.get(0));
    }

    @Test
    public void editRecipeTest() {

        Recipe recipe = new Recipe(1L, "Turos teszta", "", "20 perc", 2, "turo, tejfol", "Tegyuk fel a tesztat foni");

        editRecipePresenter.editRecipe(recipe);

        ArgumentCaptor<String> userCaptor = ArgumentCaptor.forClass(String.class);
        verify(editRecipeScreen, times(1)).showMessage(userCaptor.capture());

        List<String> capturedText = userCaptor.getAllValues();
        assertEquals("Elem sikeresen módosítva!", capturedText.get(0));
    }

    @Test
    public void removeRecipeTest() {

        recipeDetailsPresenter.removeRecipe(1L);

        ArgumentCaptor<String> userCaptor = ArgumentCaptor.forClass(String.class);
        verify(recipeDetailsScreen, times(1)).showMessage(userCaptor.capture());

        List<String> capturedText = userCaptor.getAllValues();
        assertEquals("Elem sikeresen torolve!", capturedText.get(0));
    }

    @After
    public void tearDown() {
        addRecipePresenter.detachScreen();
        recipeDetailsPresenter.detachScreen();
        editRecipePresenter.detachScreen();
    }

}
