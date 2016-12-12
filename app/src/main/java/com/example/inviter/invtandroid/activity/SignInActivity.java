package com.example.inviter.invtandroid.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.signin.SignInResponse;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;
import com.example.inviter.invtandroid.core.MessageProgressDialog;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.R.attr.height;

public class SignInActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    @Bind(R.id.txtEmail) EditText txtEmail;
    @Bind(R.id.txtPassword) EditText txtPassword;
    @Bind(R.id.imgTop) ImageView imgTop;

    private MessageProgressDialog progressDialog;
    private String emailId, password;
    private String authenticationType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_sign_in);
        init();
        fbInit();

        if (AccessToken.getCurrentAccessToken()!=null){
            // TODO need to write code here
        }
        txtEmail.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP);
        txtPassword.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP);
    }

    private void init(){
        ButterKnife.bind(this);
        progressDialog = new MessageProgressDialog(this);
        txtEmail.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
        txtPassword.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
    }

    private void fbInit(){
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker profileTracker;
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                if (profile!=null){
                    emailId = profile.getId();
                }else{
                    profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                            emailId = currentProfile.getId();
                            profileTracker.stopTracking();
                        }
                    };
                    profileTracker.startTracking();
                }
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                InviterCore.longToastBuilder(SignInActivity.this, error.getMessage());
            }
        });
    }

    private boolean validateData(){
        boolean status;
        emailId = txtEmail.getText().toString().trim();
        password = txtPassword.getText().toString().trim();

        if (emailId.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter email id!");
            return false;
        }
        if (password.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter password!");
            return false;
        }
        return true;
    }

    @OnClick(R.id.imgFbLogin)
    public void onFbLoginClick(){
        // InviterCore.shortToastBuilder(this, "Clicked");
        // LoginManager.getInstance().logInWithReadPermissions(SignInActivity.this, Arrays.asList("public_profile", "user_friends", "email"));
    }

    @OnClick(R.id.txtDontHaveAccount)
    public void onTextDontHaveAccountClick(){
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    @OnClick(R.id.txtForgotPassword)
    public void onForgotPasswordClick(){
        startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
    }

    @OnClick(R.id.imgNext)
    public void onNextClick(){
        if (validateData()){
            InviterApi.getInstance(this).singIn(emailId, password, new Callback<SignInResponse>() {
                @Override
                public void success(SignInResponse signInResponse, Response response) {
                    if(signInResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                        // TODO render dashboard
                    }
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
