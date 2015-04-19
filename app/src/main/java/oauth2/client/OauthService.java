package oauth2.client;

import oauth2.constant.OauthConstant;
import oauth2.service.IOauthService;
import retrofit.RestAdapter;

/**
 * Created by gokhan on 4/8/15.
 */
public class OauthService {

    private IOauthService oauthService;


    public IOauthService getAccessToken() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(OauthConstant.AUTHENTICATION_SERVER_URL).
                        setRequestInterceptor(new RequestInterceptorService().requestInterceptor)
                .build();
        oauthService = restAdapter.create(IOauthService.class);


        return oauthService;
    }
}