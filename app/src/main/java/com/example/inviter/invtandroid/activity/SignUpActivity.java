package com.example.inviter.invtandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.CheckEmailResponse;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.signup.SignUpBody;
import com.example.inviter.invtandroid.api.userid.UserId;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;
import com.example.inviter.invtandroid.core.MessageProgressDialog;
import com.example.inviter.invtandroid.core.Utils;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        progressDialog = new MessageProgressDialog(this);
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

    @OnClick(R.id.btnSignUp)
    public void onSignUpClick(){
        if(Utils.isNetworkAvailable(this)){
            if (validateData()){
                progressDialog.showProgress(getResources().getString(R.string.please_wait));
                InviterApi.getInstance(this).checkMail(emailId, new Callback<CheckEmailResponse>() {
                    @Override
                    public void success(CheckEmailResponse checkEmailResponse, Response response) {
                        if (checkEmailResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
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

    private void signUp(SignUpBody signUpBody){
        InviterApi.getInstance(this).signUp(signUpBody, new Callback<CheckEmailResponse>() {
            @Override
            public void success(CheckEmailResponse checkEmailResponse, Response response) {
                if (checkEmailResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    // TODO code
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismissProgress();
            }
        });
    }

    private void getUserId(String emailId){
        InviterApi.getInstance(this).getUserId(emailId, new Callback<UserId>() {
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
}
