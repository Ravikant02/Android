package com.example.inviter.invtandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.CheckEmailResponse;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Bind(R.id.txtEmail) TextView txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imgNext)
    public void onNextClick(){
        final String emailId = txtEmail.getText().toString().trim();

        if (emailId.isEmpty()){
            InviterCore.shortToastBuilder(this, "Please enter email id!");
            return;
        }

        InviterApi.getInstance(this).forgotPassword(emailId, new Callback<CheckEmailResponse>() {
            @Override
            public void success(CheckEmailResponse checkEmailResponse, Response response) {
                if (checkEmailResponse.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    InviterCore.longToastBuilder(ForgotPasswordActivity.this, checkEmailResponse.getDescription());
                }else {
                    InviterCore.longToastBuilder(ForgotPasswordActivity.this, checkEmailResponse.getDescription());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                InviterCore.longToastBuilder(ForgotPasswordActivity.this, error.getMessage());
            }
        });
    }

    @OnClick(R.id.txtAlredyHaveAccount)
    public void onAlreadyHaveAccountClick(){
        finish();
        startActivity(new Intent(ForgotPasswordActivity.this, SignInActivity.class));
    }
}
