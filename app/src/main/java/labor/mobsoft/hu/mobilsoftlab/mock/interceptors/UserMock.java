package labor.mobsoft.hu.mobilsoftlab.mock.interceptors;

import java.io.IOException;
import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.User;
import labor.mobsoft.hu.mobilsoftlab.network.recipe.LoginApi;
import labor.mobsoft.hu.mobilsoftlab.repository.MemoryRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Koszta Ádám on 2017. 05. 04..
 */

public class UserMock implements LoginApi {

    private MemoryRepository memoryRepository;

    public UserMock() {
    }

    @Override
    public Call<List<User>> GetUsers() {

        memoryRepository = new MemoryRepository();
        memoryRepository.open(null);

        Call<List<User>> call = new Call<List<User>>() {

            @Override
            public Response<List<User>> execute() throws IOException {
                List<User> users = memoryRepository.getUsers();

                return Response.success(users);
            }

            @Override
            public void enqueue(Callback<List<User>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<User>> clone() {
                return null;
            }
        };

        return call;
    }
}
