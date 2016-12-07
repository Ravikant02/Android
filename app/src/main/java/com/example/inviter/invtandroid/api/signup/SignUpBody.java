package com.example.inviter.invtandroid.api.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ravikant on 07/12/16.
 */

public class SignUpBody {
    @SerializedName("appType")
    @Expose
    private String appType;
    @SerializedName("authenticationType")
    @Expose
    private String authenticationType;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("emailID")
    @Expose
    private String emailID;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     *
     * @return
     * The appType
     */
    public String getAppType() {
        return appType;
    }

    /**
     *
     * @param appType
     * The appType
     */
    public void setAppType(String appType) {
        this.appType = appType;
    }

    /**
     *
     * @return
     * The authenticationType
     */
    public String getAuthenticationType() {
        return authenticationType;
    }

    /**
     *
     * @param authenticationType
     * The authenticationType
     */
    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     *
     * @return
     * The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     *
     * @param timeZone
     * The timeZone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     *
     * @param emailID
     * The emailID
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
