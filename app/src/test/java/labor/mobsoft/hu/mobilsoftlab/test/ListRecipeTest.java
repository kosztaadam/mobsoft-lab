package labor.mobsoft.hu.mobilsoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;


import labor.mobsoft.hu.mobilsoftlab.BuildConfig;
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
 * Created by Koszta Ádám on 2017. 05. 09..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ListRecipeTest {

    private ListPresenter listPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        listPresenter = new ListPresenter();
    }

    @Test
    public void testRecipeList() {
        ListScreen listScreen = mock(ListScreen.class);
        listPresenter.attachScreen(listScreen);
        listPresenter.refreshList();

        //ArgumentCaptor<String> recipeCaptor = ArgumentCaptor.forClass(String.class);
        //verify(listScreen, times(2)).showMessage(recipeCaptor.capture());

        //List<String> capturedRecipes = recipeCaptor.getAllValues();
        // assertEquals("paprikas krumpli", capturedRecipes.get(0));
        //assertEquals("husleves", capturedRecipes.get(1));


        ArgumentCaptor<List> recipesCaptor = ArgumentCaptor.forClass(List.class);
        verify(listScreen).listRecipes(recipesCaptor.capture());
        assertTrue(recipesCaptor.getValue().size() > 0);
    }


    @After
    public void tearDown() {
        listPresenter.detachScreen();
    }
}
