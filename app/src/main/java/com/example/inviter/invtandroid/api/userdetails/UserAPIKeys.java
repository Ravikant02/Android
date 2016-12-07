
package com.example.inviter.invtandroid.api.userdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAPIKeys {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("appID")
    @Expose
    private String appID;
    @SerializedName("appSecret")
    @Expose
    private String appSecret;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;

    /**
     * 
     * @return
     *     The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 
     * @param userID
     *     The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * 
     * @return
     *     The appID
     */
    public String getAppID() {
        return appID;
    }

    /**
     * 
     * @param appID
     *     The appID
     */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    /**
     * 
     * @return
     *     The appSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 
     * @param appSecret
     *     The appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * 
     * @return
     *     The accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 
     * @param accessToken
     *     The accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
