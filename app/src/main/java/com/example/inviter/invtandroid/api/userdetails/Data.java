
package com.example.inviter.invtandroid.api.userdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("userProfile")
    @Expose
    private UserProfile userProfile;
    @SerializedName("userPayment")
    @Expose
    private UserPayment userPayment;
    @SerializedName("userAPIKeys")
    @Expose
    private UserAPIKeys userAPIKeys;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserPayment getUserPayment() {
        return userPayment;
    }

    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }

    public UserAPIKeys getUserAPIKeys() {
        return userAPIKeys;
    }

    public void setUserAPIKeys(UserAPIKeys userAPIKeys) {
        this.userAPIKeys = userAPIKeys;
    }

}
