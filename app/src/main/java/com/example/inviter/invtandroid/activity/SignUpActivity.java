package com.example.inviter.invtandroid.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.CheckEmailResponse;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.signup.SignUpBody;
import com.example.inviter.invtandroid.api.userdetails.UserDetails;
import com.example.inviter.invtandroid.api.userid.UserId;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;
import com.example.inviter.invtandroid.core.MessageProgressDialog;
import com.example.inviter.invtandroid.core.Utils;
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

public class SignUpActivity extends AppCompatActivity {

    @Bind(R.id.txtEmail) EditText txtEmail;
    @Bind(R.id.txtPassword) EditText txtPassword;
    @Bind(R.id.txtFullName) EditText txtFullName;

    private String emailId, password, fullName;
    private MessageProgressDialog progressDialog;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_sign_up);
        init();
        fbInit();
    }

    private void init(){
        ButterKnife.bind(this);
        progressDialog = new MessageProgressDialog(this);
        txtEmail.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
        txtPassword.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
        txtFullName.getBackground().setColorFilter(getResources().getColor(R.color.bgBlue),
                PorterDuff.Mode.SRC_ATOP);
    }

    private void fbInit(){
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker profileTracker;
            @Override
            public void onSuccess(LoginResult loginResult) {
                final Profile profile = Profile.getCurrentProfile();
                final SignUpBody signUpBody = new SignUpBody();
                signUpBody.setAppType(AppConfig.AppType);
                signUpBody.setAuthenticationType(AppConfig.AuthenticationType.fbLogin);
                signUpBody.setPassword("");
                signUpBody.setTimeZone("");

                if (profile!=null){
                    signUpBody.setEmailID(profile.getId());
                    signUpBody.setName(profile.getName());
                }else{
                    profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                            signUpBody.setEmailID(currentProfile.getId());
                            signUpBody.setName(currentProfile.getName());
                            profileTracker.stopTracking();
                        }
                    };
                    profileTracker.startTracking();
                }
                // signUp(signUpBody);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                InviterCore.longToastBuilder(SignUpActivity.this, error.getMessage());
            }
        });
    }

    private boolean validateData(){
        boolean status;
        emailId = txtEmail.getText().toString().trim();
        password = txtPassword.getText().toString().trim();
        fullName = txtFullName.getText().toString().trim();

        if (emailId.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter email id!");
            return false;
        }
        if (password.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter password!");
            return false;
        }
        if (fullName.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter you full name!");
            return false;
        }
        return true;
    }

    @OnClick(R.id.imgFbLogin)
    public void onFbLoginClick(){
        // InviterCore.shortToastBuilder(this, "Clicked");
        LoginManager.getInstance().logInWithReadPermissions(SignUpActivity.this, Arrays.asList("public_profile", "user_friends", "email"));
    }

    @OnClick(R.id.txtAlredyHaveAccount)
    public void onAlreadyHaveAccountClick(){
        startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
    }

    @OnClick(R.id.imgNext)
    public void onSignUpClick(){
        if(Utils.isNetworkAvailable(this)){
            if (validateData()){
                progressDialog.showProgress(getResources().getString(R.string.please_wait));
                InviterApi.getInstance().checkMail(emailId, new Callback<CheckEmailResponse>() {
                    @Override
                    public void success(CheckEmailResponse checkEmailResponse, Response response) {
                        if (checkEmailResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                            progressDialog.dismissProgress();
                            InviterCore.shortToastBuilder(SignUpActivity.this, "User already exists!");
                        }else {
                            // InviterCore.shortToastBuilder(SignUpActivity.this, "Success");
                            SignUpBody signUpBody = new SignUpBody();
                            signUpBody.setAppType(AppConfig.AppType);
                            signUpBody.setAuthenticationType(AppConfig.AuthenticationType.inviterLogin);
                            signUpBody.setEmailID(emailId);
                            signUpBody.setName(fullName);
                            signUpBody.setPassword(password);
                            signUpBody.setTimeZone("");

                            signUp(signUpBody);
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismissProgress();
                        InviterCore.shortToastBuilder(SignUpActivity.this, error.getMessage());
                    }
                });
            }
        }else {
            InviterCore.shortToastBuilder(this, "Please check Network connection and try again!");
        }
    }

    private void signUp(final SignUpBody signUpBody){
        InviterApi.getInstance().signUp(signUpBody, new Callback<CheckEmailResponse>() {
            @Override
            public void success(CheckEmailResponse checkEmailResponse, Response response) {
                if (checkEmailResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    // startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    if (signUpBody.getAppType().equals(AppConfig.AuthenticationType.fbLogin)){
                        getUserDetails(checkEmailResponse.getUserID());
                        return;
                    }
                    progressDialog.dismissProgress();
                    thankYouDialog();
                }else{
                    InviterCore.longSnackbarBuilder(SignUpActivity.this, checkEmailResponse.getDescription());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismissProgress();
                InviterCore.longSnackbarBuilder(SignUpActivity.this, error.getMessage());
            }
        });
    }

    private void getUserDetails(String userID){
        InviterApi.getInstance().getUserData(userID, new Callback<UserDetails>() {
            @Override
            public void success(UserDetails userDetails, Response response) {
                if (userDetails.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
                    sharedPreferences
                            .edit()
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_USER_ID, userDetails.getData().getUserProfile().getUserID())
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_EMAILID, emailId)
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_USER_NAME, userDetails.getData().getUserProfile().getFirstName()+ " "+userDetails.getData().getUserProfile().getLastName())
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_ACCESS_TOKEN, userDetails.getData().getUserAPIKeys().getAccessToken())
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_APP_SECRET, userDetails.getData().getUserAPIKeys().getAppSecret())
                            .putString(AppConfig.SHARED_PREFERENCE_KEY_APP_ID, userDetails.getData().getUserAPIKeys().getAppID())
                            .putBoolean(AppConfig.SHARED_PREFERENCE_KEY_IS_LOGIN, true)
                            .apply();
                    progressDialog.dismissProgress();
                    finish();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                }else{
                    InviterCore.longSnackbarBuilder(SignUpActivity.this, userDetails.getDescription());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismissProgress();
                InviterCore.longSnackbarBuilder(SignUpActivity.this, error.getMessage());
            }
        });
    }

    private void getUserId(String emailId){
        InviterApi.getInstance().getUserId(emailId, new Callback<UserId>() {
            @Override
            public void success(UserId userId, Response response) {
                if (userId.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    progressDialog.dismissProgress();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismissProgress();
            }
        });
    }

    private void thankYouDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.thankyou_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button button = (Button) dialog.findViewById(R.id.btnLogin);
        dialog.setCancelable(false);
        dialog.show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
