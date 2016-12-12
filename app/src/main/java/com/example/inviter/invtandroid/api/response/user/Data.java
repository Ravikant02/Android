
package com.example.inviter.invtandroid.api.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("userProfile")
    @Expose
    public UserProfile userProfile;
    @SerializedName("userPayment")
    @Expose
    public UserPayment userPayment;
    @SerializedName("userAPIKeys")
    @Expose
    public UserAPIKeys userAPIKeys;

}
