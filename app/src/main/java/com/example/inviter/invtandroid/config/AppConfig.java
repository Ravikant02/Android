package com.example.inviter.invtandroid.config;

/**
 * Created by Ravikant on 06/12/16.
 */
public class AppConfig {

    // SHARED PREFERENCE RELATED
    public static final String SHARED_PREFERENCE_NAME = "INVITER";
    public static final String SHARED_PREFERENCE_KEY_USER_ID = "userID";
    public static final String SHARED_PREFERENCE_KEY_EMAILID = "emailID";
    public static final String SHARED_PREFERENCE_KEY_USER_NAME = "userName";
    public static final String SHARED_PREFERENCE_KEY_ACCESS_TOKEN = "accessToken";
    public static final String SHARED_PREFERENCE_KEY_APP_SECRET = "appSecret";
    public static final String SHARED_PREFERENCE_KEY_APP_ID = "appID";
    public static final String SHARED_PREFERENCE_KEY_IS_APP_FIRST_TIME = "isAppFirstTime";
    public static final String SHARED_PREFERENCE_KEY_IS_LOGIN = "isLogin";
    public static final String SHARED_PREFERENCE_KEY_VIDEO_LENGTH = "videoLength";
    // public static final String BASE_URL = "https://testing.inviter.com/api/";
    // public static final String HOST_URL = "https://testing.inviter.com/";
    public static final String BASE_URL = "https://inviter.com/";
    public static final String HOST_URL = "https://inviter.com/";

    public static final String AppId = "appID";
    public static final String AppSecret = "appSecret";
    public static final String AccessToken = "accessToken";
    public static final String successResponse = "success";
    public static final String AppType = "3"; // FOR ANDROID APP TYPE IS 3

    // FOR LOCATION AUTO COMPLETE, USED IN EventVenuePickerActivity
    public static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    public static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    public static final String OUT_JSON = "/json";
    public static final String API_KEY = "AIzaSyB4x9L8tZ2mIZAF93GprbUAJyA-oN4B4FQ";

    public static class EventType{
        public static final int INVITATION = 1;
    }

    public static class AuthenticationType{
        public static final String inviterLogin = "0";
        public static final String fbLogin = "1";
    }
}
