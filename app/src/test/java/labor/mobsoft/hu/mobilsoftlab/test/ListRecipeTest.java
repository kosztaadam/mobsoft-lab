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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        ArgumentCaptor<List> recipesCaptor = ArgumentCaptor.forClass(List.class);
        verify(listScreen).listRecipes(recipesCaptor.capture());
        assertTrue(recipesCaptor.getValue().size() > 0);
    }


    @After
    public void tearDown() {
        listPresenter.detachScreen();
    }
}
