package oauth2.service;

import oauth2.response.ApiResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by gokhan on 4/18/15.
 */
public interface IApiService {

    @GET("/")
    void getMessage(Callback<ApiResponse> responseCallback);

}
