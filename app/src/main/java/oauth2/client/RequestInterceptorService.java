package oauth2.client;

/**
 * Created by gokhan on 4/15/15.
 */
public class RequestInterceptorService {


    retrofit.RequestInterceptor requestInterceptor = new retrofit.RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Authorization", "Bearer 8CM18fqeO9iRN8orFwnZ50rVqr9QAtYc5mEGXlqsb1c=");
            request.addHeader("User-Agent", "Android");
        }


    };


}

