package com.example.inviter.invtandroid.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.core.InviterCore;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.height;

public class SignInActivity extends AppCompatActivity {
    private CallbackManager callbackManager;

    @Bind(R.id.txtEmail) EditText txtEmail;
    @Bind(R.id.txtPassword) EditText txtPassword;
    @Bind(R.id.imgTop) ImageView imgTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();

        if (AccessToken.getCurrentAccessToken()!=null){
            // TODO need to write code here
        }

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        /*BitmapDrawable bgImageBitmap=(BitmapDrawable) this.getResources().getDrawable(R.drawable.bg_top_homepage);
        int bgImageHeight = bgImageBitmap.getBitmap().getHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, bgImageHeight-(height/2), 0, 0); //(left, top, right, bottom);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        imgTop.setLayoutParams(layoutParams);*/

        txtEmail.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP);
        txtPassword.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP);
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

}
