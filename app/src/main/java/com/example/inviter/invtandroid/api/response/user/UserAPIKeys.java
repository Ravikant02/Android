
package com.example.inviter.invtandroid.api.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserAPIKeys {

    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("appID")
    @Expose
    public String appID;
    @SerializedName("appSecret")
    @Expose
    public String appSecret;
    @SerializedName("accessToken")
    @Expose
    public String accessToken;

}
