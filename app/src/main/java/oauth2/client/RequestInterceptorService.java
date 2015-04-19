package oauth2.client;

import retrofit.RequestInterceptor;
import ui.MainActivity;

/**
 * Created by gokhan on 4/15/15.
 */
public class RequestInterceptorService{

    RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {


            request.addHeader("Authorization", "Bearer");
            request.addHeader("User-Agent", "Android");
        }


    };


}

