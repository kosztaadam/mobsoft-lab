package labor.mobsoft.hu.mobilsoftlab.interactor.login.event;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.User;

/**
 * Created by Koszta Ádám on 2017. 05. 04..
 */

public class GetUsersEvent {
    private int code;
    private List<User> users;
    private Throwable throwable;

    public GetUsersEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
