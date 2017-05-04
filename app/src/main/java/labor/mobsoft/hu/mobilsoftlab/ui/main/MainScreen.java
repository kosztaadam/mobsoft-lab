package labor.mobsoft.hu.mobilsoftlab.ui.main;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.User;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface MainScreen {
    void showMessage(String text);
    void getAuth(List<User> users);
}
