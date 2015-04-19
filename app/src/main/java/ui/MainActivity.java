package ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import oauth2.client.ApiService;
import oauth2.client.OauthService;
import oauth2.client.SignUpService;
import oauth2.client.UserService;
import oauth2.constant.OauthConstant;
import oauth2.request.AccessTokenRequest;
import oauth2.request.SignUpRequest;
import oauth2.response.AccessTokenResponse;
import oauth2.response.ApiResponse;
import oauth2.response.SignUpResponse;
import oauth2.response.UserResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofitwrapper.retrofitoauth_2.R;


public class MainActivity extends ActionBarActivity {

    private SharedPreferences sharedpreferences;
    private Button btnSignUp;
    private EditText txtUsername;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtName;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUser();
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtName = (EditText) findViewById(R.id.txtName);
        sharedpreferences = getSharedPreferences("AouthToken", Context.MODE_PRIVATE);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        //   getMessage();
        // getAccessToken();
    }


    public void getUser() {
        UserService userService = new UserService();
        userService.getUser().user(new Callback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse, Response response) {
                Toast.makeText(getApplicationContext(), userResponse.getUserId(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getAccessToken() {
        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        accessTokenRequest.setClient_id("client");
        accessTokenRequest.setClient_secret("client");
        accessTokenRequest.setGrant_type("password");
        accessTokenRequest.setUsername("android");
        accessTokenRequest.setPassword("android");
        OauthService service = new OauthService();

        //Taken new access token.
        service.getAccessToken().getAccessToken(accessTokenRequest, new Callback<AccessTokenResponse>() {
            @Override
            public void success(AccessTokenResponse accessTokenResponse, Response response) {

                if (accessTokenResponse.getAccess_token() != null) {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(OauthConstant.ACCESS_TOKEN, accessTokenResponse.getAccess_token());
                    editor.commit();
                } else {
                    Toast.makeText(getApplicationContext(), "Notoken", Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void getMessage() {
        ApiService apiService = new ApiService();
        apiService.getMessage().getMessage(new Callback<ApiResponse>() {
            @Override
            public void success(ApiResponse apiResponse, Response response) {
                Log.e(TAG, apiResponse.getMsg());
                Toast.makeText(getApplicationContext(), apiResponse.getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    public void signUp() {

        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setEmail(txtEmail.getText().toString());
        signUpRequest.setName(txtName.getText().toString());
        signUpRequest.setPassword(txtPassword.getText().toString());
        signUpRequest.setUsername(txtUsername.getText().toString());
        SignUpService signUpService = new SignUpService();
        signUpService.signUpService().signUp(signUpRequest, new Callback<SignUpResponse>() {
            @Override
            public void success(SignUpResponse signUpResponse, Response response) {
                Toast.makeText(getApplicationContext(), signUpResponse.getData(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
