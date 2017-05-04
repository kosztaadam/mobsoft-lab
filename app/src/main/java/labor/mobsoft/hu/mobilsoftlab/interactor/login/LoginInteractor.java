package labor.mobsoft.hu.mobilsoftlab.interactor.login;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.interactor.login.event.GetUsersEvent;
import labor.mobsoft.hu.mobilsoftlab.model.User;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.LoginApi;
import labor.mobsoft.hu.mobilsoftlab.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Koszta Ádám on 2017. 05. 04..
 */

public class LoginInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    LoginApi loginApi;

    public LoginInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getUsers() {
        Call<List<User>> queryCall = loginApi.GetUsers();

        GetUsersEvent event = new GetUsersEvent();
        try {
            Response<List<User>> response = queryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Something went wrong!");
            }
            event.setCode(response.code());
            List<User> users = response.body();
            event.setUsers(users);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
