
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

    /**
     * 
     * @return
     *     The userProfile
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    /**
     * 
     * @param userProfile
     *     The userProfile
     */
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * 
     * @return
     *     The userPayment
     */
    public UserPayment getUserPayment() {
        return userPayment;
    }

    /**
     * 
     * @param userPayment
     *     The userPayment
     */
    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }

    /**
     * 
     * @return
     *     The userAPIKeys
     */
    public UserAPIKeys getUserAPIKeys() {
        return userAPIKeys;
    }

    /**
     * 
     * @param userAPIKeys
     *     The userAPIKeys
     */
    public void setUserAPIKeys(UserAPIKeys userAPIKeys) {
        this.userAPIKeys = userAPIKeys;
    }

}
