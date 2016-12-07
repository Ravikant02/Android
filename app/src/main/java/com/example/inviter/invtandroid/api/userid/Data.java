
package com.example.inviter.invtandroid.api.userid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("userID")
    @Expose
    private String userID;

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

}
