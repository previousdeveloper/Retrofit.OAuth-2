# Retrofit-OAuth-2-Resource-Owner-Password-Credentials
Simple OAuth2 Resource Owner Password Credentials.

GRADLE BUILD

```java
 compile 'com.squareup.retrofit:retrofit:1.9.0'
```

#GetAccessToken

This will add the necessary oAuth headers to each request.
```java
  public interface IOauthService {

    @POST("/oauth/token")
    void getAccessToken(@Body AccessTokenRequest accessTokenRequest,
                        Callback<AccessTokenResponse> responseCallback);
}
```

#Send Token Every Request

```java
   RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Authorization", "Bearer" + token);
            request.addHeader("User-Agent", "Android");
        }
    };
```




