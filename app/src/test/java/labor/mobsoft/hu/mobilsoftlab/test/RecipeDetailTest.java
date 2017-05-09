package labor.mobsoft.hu.mobilsoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.BuildConfig;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListScreen;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainScreen;
import labor.mobsoft.hu.mobilsoftlab.utils.RobolectricDaggerTestRunner;

import static labor.mobsoft.hu.mobilsoftlab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by koszt on 2017. 05. 09..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeDetailTest {

    private RecipeDetailsPresenter recipeDetailsPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        recipeDetailsPresenter = new RecipeDetailsPresenter();
    }

    @Test
    public void testRecipeDetail() {
        RecipeDetailsScreen recipeDetailsScreen = mock(RecipeDetailsScreen.class);
        recipeDetailsPresenter.attachScreen(recipeDetailsScreen);
        recipeDetailsPresenter.getRecipe(1L);

        ArgumentCaptor<String> userCaptor = ArgumentCaptor.forClass(String.class);
        verify(recipeDetailsScreen, times(1)).showError(userCaptor.capture());

        List<String> capturedRecipe = userCaptor.getAllValues();
        assertEquals("paprikas krumpli", capturedRecipe.get(0));
    }


    @After
    public void tearDown() {
        recipeDetailsPresenter.detachScreen();
    }
}