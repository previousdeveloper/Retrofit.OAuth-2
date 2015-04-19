package oauth2.service;

import oauth2.request.AccessTokenRequest;
import oauth2.response.AccessTokenResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;


public interface IOauthService {

    @POST("/oauth/token")
    void getAccessToken(@Body AccessTokenRequest accessTokenRequest,
                        Callback<AccessTokenResponse> responseCallback);


}
