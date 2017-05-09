package labor.mobsoft.hu.mobilsoftlab.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;


import labor.mobsoft.hu.mobilsoftlab.BuildConfig;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainPresenter;
import labor.mobsoft.hu.mobilsoftlab.ui.main.MainScreen;
import labor.mobsoft.hu.mobilsoftlab.utils.RobolectricDaggerTestRunner;

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
public class UserTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void testUserList() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        mainPresenter.getUsers();

        ArgumentCaptor<String> userCaptor = ArgumentCaptor.forClass(String.class);
        verify(mainScreen, times(2)).showMessage(userCaptor.capture());

        List<String> capturedUsers = userCaptor.getAllValues();
        assertEquals("bela", capturedUsers.get(0));
        assertEquals("adam", capturedUsers.get(1));
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
