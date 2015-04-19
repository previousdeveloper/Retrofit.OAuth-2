package oauth2.service;

import oauth2.request.SignUpRequest;
import oauth2.response.SignUpResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by gokhan on 4/18/15.
 */
public interface ISignUpService {
    @POST("/signup")
    void signUp(@Body SignUpRequest signUpRequest,
                        Callback<SignUpResponse> signUpResponseCallback);
}
