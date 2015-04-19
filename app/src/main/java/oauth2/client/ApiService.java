package oauth2.client;

import oauth2.constant.OauthConstant;
import oauth2.service.IApiService;
import retrofit.RestAdapter;

/**
 * Created by gokhan on 4/18/15.
 */
public class ApiService {

    private IApiService _apiService;


    public IApiService getMessage() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(OauthConstant.AUTHENTICATION_SERVER_URL).
                        setRequestInterceptor(new RequestInterceptorService().requestInterceptor)
                .build();
        _apiService = restAdapter.create(IApiService.class);


        return _apiService;
    }
}


