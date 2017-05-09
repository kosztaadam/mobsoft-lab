package labor.mobsoft.hu.mobilsoftlab.network.recipe;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Koszta Ádám on 2017. 05. 04..
 */

public interface LoginApi {

    @GET("users")
    Call<List<User>> GetUsers();

}