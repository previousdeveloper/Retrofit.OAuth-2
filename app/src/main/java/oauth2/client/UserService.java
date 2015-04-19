package oauth2.client;

import oauth2.constant.OauthConstant;
import oauth2.service.IUserService;
import retrofit.RestAdapter;

/**
 * Created by gokhan on 4/18/15.
 */
public class UserService {

    private IUserService _iUserService;


    public IUserService getUser() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(OauthConstant.AUTHENTICATION_SERVER_URL).
                        setRequestInterceptor(new RequestInterceptorService().requestInterceptor)
                .build();
        _iUserService = restAdapter.create(IUserService.class);


        return _iUserService;
    }
}
