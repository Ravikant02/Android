package com.example.inviter.invtandroid.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.BuildConfig;
import android.util.Log;

import com.example.inviter.invtandroid.api.response.createevent.CreateEvent;
import com.example.inviter.invtandroid.api.response.createevent.CreateEventResponse;
import com.example.inviter.invtandroid.api.response.encodevideo.EncodeVideoResponseJSON;
import com.example.inviter.invtandroid.api.response.encodevideojob.EncodeJobResponseJSON;
import com.example.inviter.invtandroid.api.response.eventslibrary.EventLibrary;
import com.example.inviter.invtandroid.api.signin.SignInResponse;
import com.example.inviter.invtandroid.api.signup.SignUpBody;
import com.example.inviter.invtandroid.api.uploadResponse.UploadResponse;
import com.example.inviter.invtandroid.api.userdetails.UserDetails;
import com.example.inviter.invtandroid.api.userid.UserId;
import com.example.inviter.invtandroid.config.AppConfig;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedFile;

/**
 * Created by Inwiter on 21/03/16.
 */
public class InviterApi {

    private static InviterApi inviterApi = new InviterApi();
    public static InviterService inviterService;
    private Context context;

    public static InviterApi getInstance() {
        if (inviterApi == null) inviterApi = new InviterApi();
        return inviterApi;
    }

    public void uploadContent(Context con, String userID, String uploadType, TypedFile typedFile,
                              Callback<UploadResponse>callback) {
        this.context = con;
        getServiceInstanceWithHeaders().upload(userID, uploadType, typedFile, callback);

    }
    
    public void createEvent(Context con, String userID, CreateEvent createEventJSON, Callback<CreateEventResponse> callback) {
        getServiceInstanceWithHeaders().createEvent(userID, createEventJSON, callback);
    }

    public void encodeVideo(Context con, String userID, String filPath, String s3FilePath, String baseURL,
                            String fileType, String serverIP, String length,
                            Callback<EncodeVideoResponseJSON> callback) {
        this.context = con;
        getServiceInstanceWithHeaders().encodeVideo(userID, filPath, s3FilePath, baseURL, fileType,
                serverIP, length, callback);
    }

    public void getEncodeStatus(Context con, String userID, String jobID, Callback<EncodeJobResponseJSON>callback){
        this.context = con;
        getServiceInstanceWithHeaders().getEncodeJobStatus(userID, jobID, callback);
    }
    /*
    public void saveEvent(CreateEventJSON createEventJSON, Callback<EventResponse> response)
    {
        Log.i("Test", "Save event JSON " + new Gson().toJson(createEventJSON));
        getServiceInstance(true, "266a9e17525a90988817ada12e941272", "1559395096546d750793089",
                "bOx9wOUjIW9U81U2").saveEvent("2838023a778dfaecdc212708f721b788", createEventJSON, "save", false, false, "", response);
//        getServiceInstance(true, "74693453a370754a3a4e5144f9652acf", "1725972831546cbe87051d1",
//                "7SCulE9LaqVo0agD").saveEvent("f457c545a9ded88f18ecee47145a72c0", createEventJSON, "save", false, false, "", response);
    }

    public void addGuest(String userID, String eventID, String businessName, String hostName,
                         String hostEmailID, String eventStatus, AddGuestJSON addGuestJSON,
                         Callback<AddGuestResponse> callback){
        getInviterService().addGuests(userID, eventID, businessName, hostName, hostEmailID,
                eventStatus, addGuestJSON, callback);
    }

    public void reSaveEvent(CreateEventJSON createEventJSON, Callback<EventResponse> response) {
//        Log.i("Test", "Re-Save event JSON " + new Gson().toJson(createEventJSON));
        getServiceInstance(true, "266a9e17525a90988817ada12e941272", "1559395096546d750793089",
                "bOx9wOUjIW9U81U2").reSaveEvent("2838023a778dfaecdc212708f721b788", createEventJSON, "save", false, true, "", response);
    }*/

    public void getEvents(Context con, String userID, String eventRequestType, String startLimit, String offset, Callback<EventLibrary> callback) {
        this.context = con;
        getServiceInstanceWithHeaders().getEvents(userID, eventRequestType, startLimit, offset, callback);
    }

    public void getUserData(String userID, Callback<UserDetails> callback) {
        getServiceInstance().getUserData(userID, callback);
    }

    public void checkMail(String emailID, Callback<CheckEmailResponse> callback){
        getServiceInstance().checkMail(emailID, callback);
    }

    public void signUp(SignUpBody signUpBody, Callback<CheckEmailResponse>callback){
        getServiceInstance().signUp(signUpBody, callback);
    }

    public void getUserId(String emailId, Callback<UserId>callback){
        getServiceInstance().getUserId(emailId, callback);
    }

    public void forgotPassword(String emailId, Callback<CheckEmailResponse>callback){
        getServiceInstance().forgotPassword(emailId, callback);
    }

    public void singIn(String emailId, String password, Callback<SignInResponse>callback){
        getServiceInstance().signIn(emailId, password, callback);
    }


    public InviterService getServiceInstanceWithHeaders() {

        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        final String appID = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_APP_ID, "");
        final String appSecret = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_APP_SECRET, "");
        final String accessToken = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_ACCESS_TOKEN, "");

        if (inviterService == null)
        {
            OkHttpClient client = new OkHttpClient();
            RequestInterceptor requestInterceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader(AppConfig.AppId, appID);
                    request.addHeader(AppConfig.AppSecret, appSecret);
                    request.addHeader(AppConfig.AccessToken, accessToken);
                }
            };

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(AppConfig.BASE_URL)
                    .setRequestInterceptor(requestInterceptor)
                    .setClient(new OkClient(client))
                    .setConverter(new GsonConverter(new Gson()))
                    .build();
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            if (BuildConfig.DEBUG) {
                restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            }
            inviterService = restAdapter.create(InviterService.class);
        }
        return inviterService;
    }

    public static InviterService getServiceInstance() {
        if (inviterService == null)
        {
            OkHttpClient client = new OkHttpClient();
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(AppConfig.HOST_URL)
                    .setConverter(new GsonConverter(new Gson()))
                    .setClient(new OkClient(client))
                    .build();
            inviterService = restAdapter.create(InviterService.class);
        }
        return inviterService;
    }

}
