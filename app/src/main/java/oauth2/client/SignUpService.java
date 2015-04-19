package oauth2.client;

import oauth2.constant.OauthConstant;
import oauth2.service.ISignUpService;
import retrofit.RestAdapter;

/**
 * Created by gokhan on 4/18/15.
 */
public class SignUpService {

    private ISignUpService _signUpService;


    public ISignUpService signUpService() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(OauthConstant.AUTHENTICATION_SERVER_URL).
                        setRequestInterceptor(new RequestInterceptorService().requestInterceptor)
                .build();
        _signUpService = restAdapter.create(ISignUpService.class);


        return _signUpService;
    }
}
