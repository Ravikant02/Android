package com.example.inviter.invtandroid.social;

import android.content.Context;
import android.content.Intent;

import com.example.inviter.invtandroid.core.InviterCore;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

/**
 * Created by Ravikant on 10/12/16.
 */

public class FacebookApi {
    private static CallbackManager callbackManager;

    public static void init(final Context context){
        FacebookSdk.sdkInitialize(context);
        AppEventsLogger.activateApp(context);

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker profileTracker;
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                if (profile!=null){

                }else{
                    profileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
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
                InviterCore.longToastBuilder(context, error.getMessage());
            }
        });
    }

    public void fbActivityCallback(int requestCode, int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void logoutFromFacebook(){
        try {
            if (AccessToken.getCurrentAccessToken() == null) {
                return; // already logged out
            }
            String facebook_id="";
            GraphRequest graphRequest=new GraphRequest(AccessToken.getCurrentAccessToken(), "/ "+facebook_id+"/permissions/", null,
                    HttpMethod.DELETE, new GraphRequest.Callback() {
                @Override
                public void onCompleted(GraphResponse graphResponse) {
                    LoginManager.getInstance().logOut();
                }
            });

            graphRequest.executeAsync();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
