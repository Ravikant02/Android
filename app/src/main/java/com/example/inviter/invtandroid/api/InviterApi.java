package com.example.inviter.invtandroid.api;

import android.content.Context;
import android.support.v4.BuildConfig;
import android.util.Log;

import com.example.inviter.invtandroid.api.signup.SignUpBody;
import com.example.inviter.invtandroid.api.userid.UserId;
import com.example.inviter.invtandroid.config.AppConfig;
import com.google.gson.Gson;
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

    public static InviterApi getInstance(Context context) {
        if (inviterApi == null)
        {
            inviterApi = new InviterApi();
        }
        return inviterApi;
    }

    /*public void uploadContent(String userID, String uploadType, TypedFile typedFile,
                              Callback<UploadResponse>callback)
    {
        getServiceInstance(true, "5d96df6dc4f1299fb897f24e39d79c10", "188977722455bb0fc15ae61",
                "xNMTSWfSJiDWYmyz").upload(userID, uploadType, typedFile, callback);

    }
    
    public void createEvent(CreateEventJSON createEventJSON, Callback<EventResponse> response)
    {
        Log.i("Test", "Create event JSON " + new Gson().toJson(createEventJSON));
        getServiceInstance(true, "266a9e17525a90988817ada12e941272", "1559395096546d750793089",
                "bOx9wOUjIW9U81U2").createEvent("2838023a778dfaecdc212708f721b788", createEventJSON, "", "create", false, response);
    }

    public void encodeVideo(String userID, String filPath, String s3FilePath, String baseURL,
                            String fileType, String serverIP, String length,
                            Callback<EncodeVideoResponseJSON> callback)
    {
        getInviterService().encodeVideo(userID, filPath, s3FilePath, baseURL, fileType,
                serverIP, length, callback);
    }

    public void getEncodeStatus(String userID, String jobID, Callback<EncodeJobResponseJSON>callback){
        getInviterService().getEncodeJobStatus(userID, jobID, callback);
    }

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
    }

    public void getEvents(String eventRequestType, String startLimit, String offset, Callback<EventsResponseJSON> eventsResponseJSONCallback)
    {
        getServiceInstance(true, "266a9e17525a90988817ada12e941272", "1559395096546d750793089",
                "bOx9wOUjIW9U81U2").getEvents("2838023a778dfaecdc212708f721b788", eventRequestType, startLimit, offset, eventsResponseJSONCallback);
    }
    public void getUserData(Callback<UserResponseJSON> userResponseJSONCallback)
    {
        getServiceInstance(false, null, null, null).getUserData("2838023a778dfaecdc212708f721b788", userResponseJSONCallback);
    }*/

    public void checkMail(String emailID, Callback<CheckEmailResponse> callback){
        getServiceInstance().checkMail(emailID, callback);
    }

    public void signUp(SignUpBody signUpBody, Callback<CheckEmailResponse>callback){
        getServiceInstance().signUp(signUpBody, callback);
    }

    public void getUserId(String emailId, Callback<UserId>callback){
        getServiceInstance().getUserId(emailId, callback);
    }


    public static InviterService getServiceInstance(final String appID,
                                                    final String appSecret,
                                                    final String accessToken)
    {
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
