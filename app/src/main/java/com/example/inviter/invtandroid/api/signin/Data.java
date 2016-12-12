package com.example.inviter.invtandroid.api.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ravikant on 10/12/16.
 */

public class Data {
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("emailID")
    @Expose
    private String emailID;
    @SerializedName("emailVerify")
    @Expose
    private String emailVerify;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("alternativeEmailId")
    @Expose
    private String alternativeEmailId;

    /**
     *
     * @return
     * The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
     * The emailVerify
     */
    public String getEmailVerify() {
        return emailVerify;
    }

    /**
     *
     * @param emailVerify
     * The emailVerify
     */
    public void setEmailVerify(String emailVerify) {
        this.emailVerify = emailVerify;
    }

    /**
     *
     * @return
     * The paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @param paymentType
     * The paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     *
     * @return
     * The alternativeEmailId
     */
    public String getAlternativeEmailId() {
        return alternativeEmailId;
    }

    /**
     *
     * @param alternativeEmailId
     * The alternativeEmailId
     */
    public void setAlternativeEmailId(String alternativeEmailId) {
        this.alternativeEmailId = alternativeEmailId;
    }
}
