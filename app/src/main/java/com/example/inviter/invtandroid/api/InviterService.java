package com.example.inviter.invtandroid.api;

import com.example.inviter.invtandroid.api.response.encodevideo.EncodeVideoResponseJSON;
import com.example.inviter.invtandroid.api.response.encodevideojob.EncodeJobResponseJSON;
import com.example.inviter.invtandroid.api.signin.SignInResponse;
import com.example.inviter.invtandroid.api.signup.SignUpBody;
import com.example.inviter.invtandroid.api.uploadResponse.UploadResponse;
import com.example.inviter.invtandroid.api.userdetails.UserDetails;
import com.example.inviter.invtandroid.api.userid.UserId;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * Created by Ravikant on 06/12/16.
 */

public interface InviterService {
    @Multipart
    @POST("/user/checkEmail")
    void checkMail(@Part("emailID") String emailID, Callback<CheckEmailResponse> callback);

    @Multipart
    @POST("/app/signup")
    void signUp(@Part("userData")SignUpBody signUpBody, Callback<CheckEmailResponse>callback);

    @GET("/user/getuserid/")
    void getUserId(@Path("email") String emailID, Callback<UserId> callback);

    @Multipart
    @POST("/forgotpassword")
    void forgotPassword(@Part("emailID") String emailID, Callback<CheckEmailResponse> callback);

    @Multipart
    @POST("/signin/doSignIn")
    void signIn(@Part("emailID") String emailID,
                        @Part("password") String password,
                        Callback<SignInResponse> callback);

    @Multipart
    @POST("/user/{userID}/encode")
    void encodeVideo(@Path("userID") String userID,
                            @Part("filePath") String filePath,
                            @Part("s3FilePath") String s3FilePath,
                            @Part("baseURL") String baseURL,
                            @Part("fileType") String fileType,
                            @Part("serverIp") String serverIp,
                            @Part("length") String length,
                            Callback<EncodeVideoResponseJSON> callback);

    @GET("/user/{userID}/encode")
    void getEncodeJobStatus(@Path("userID") String userID,
                                   @Query("jobID") String jobID,
                                   Callback<EncodeJobResponseJSON> callback);
    @Multipart
    @POST("/user/{userID}/upload/")
    void upload(@Path("userID") String userID,
                @Part("uploadType") String uploadType,
                @Part("file") TypedFile typedFile,
                Callback<UploadResponse> callback);

    @GET("/user/getuserdata/{userID}")
    public void getUserData(@Path("userID") String userID, Callback<UserDetails> callback);

    //@FormUrlEncoded
    /*
    @Multipart
    @POST("/user/{userID}/events")
    public void createEvent(@Path("userID") String userID,
                            @Part("JSONData") CreateEventJSON createEventJSON,
                            @Part("eventID") String eventID,
                            @Part("eventCreationType") String eventCreationType,
                            @Part("update") boolean canUpdate,
                            Callback<EventResponse> response);

    @GET("/user/{userID}/events/{eventID}")
    public void getEvent(@Path("userID") String userID,
                         @Path("eventID") String eventID,
                         Callback<CreateEventJSONResponse> createEventJSONCallback);

    @Multipart
    @PUT("/user/{userID}/events")
    public void saveEvent(@Path("userID") String userID,
                          @Part("JSONData") CreateEventJSON createEventJSON,
                          @Part("eventCreationType") String eventCreationType,
                          @Part("notifyUpdateEmails") boolean notifyUpdateEmails,
                          @Part("update") boolean update,
                          @Part("eventID") String eventID,
                          Callback<EventResponse> callback);
    @Multipart
    @POST("/user/{userID}/events")
    public void reSaveEvent(@Path("userID") String userID,
                            @Part("JSONData") CreateEventJSON createEventJSON,
                            @Part("eventCreationType") String eventCreationType,
                            @Part("notifyUpdateEmails") boolean notifyUpdateEmails,
                            @Part("update") boolean update,
                            @Part("eventID") String eventID,
                            Callback<EventResponse> callback);


    @Multipart
    @POST("/user/{userID}/utcdate")
    public void validateUTCDate(@Path("userID") String userID,
                                @Part("validateData") UTCDateRequestJSON utcDateRequestJSON,
                                Callback<UTCDateResponseJSON> callback);
    @Multipart
    @PUT("/user/{userID}/addguests/{eventID}")
    public void addGuests(@Path("userID") String userID, @Path("eventID") String eventID,
                          @Part("businessName") String businessName,
                          @Part("hostName") String hostName,
                          @Part("hostEmailID") String hostEmailID,
                          @Part("eventStatus") String eventStatus,
                          @Part("JOSNData") AddGuestJSON addGuestJSON,
                          Callback<AddGuestResponse> responseCallback);

    @GET("/user/{userID}/events")
    public void getEvents(@Path("userID") String userID, @Query("eventRequestType") String eventRequestType, @Query("intStartLimit") String startLimit, @Query("intEndLimit") String offset, Callback<EventsResponseJSON> callback);

    */

}
