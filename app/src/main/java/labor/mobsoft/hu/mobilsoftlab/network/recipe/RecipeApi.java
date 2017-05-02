package labor.mobsoft.hu.mobilsoftlab.network.recipe;

/**
 * Created by Koszta Ádám on 2017. 05. 02..
 */

import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import retrofit2.Call;
import retrofit2.http.*;


public interface RecipeApi {

    /**
     * Create a new instance of the model and persist it into the data source.
     *
     * @param data Model instance data
     * @return Call<Void>
     */

    @POST("Todo")
    Call<Void> saveFavourite(
            @Body Recipe data
    );


}