
package com.example.inviter.invtandroid.api.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserPayment {

    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("emailID")
    @Expose
    public String emailID;
    @SerializedName("paymentType")
    @Expose
    public String paymentType;
    @SerializedName("remainingEventsCount")
    @Expose
    public Integer remainingEventsCount;
    @SerializedName("customerLimit")
    @Expose
    public String customerLimit;
    @SerializedName("videoLength")
    @Expose
    public String videoLength;
    @SerializedName("videoLengthInSec")
    @Expose
    public Integer videoLengthInSec;
    @SerializedName("paymentStatus")
    @Expose
    public String paymentStatus;
    @SerializedName("paymentSchedule")
    @Expose
    public String paymentSchedule;
    @SerializedName("enrolledDate")
    @Expose
    public String enrolledDate;
    @SerializedName("expiryDate")
    @Expose
    public String expiryDate;
    @SerializedName("payment")
    @Expose
    public String payment;
    @SerializedName("paidBy")
    @Expose
    public String paidBy;
    @SerializedName("paidDate")
    @Expose
    public String paidDate;
    @SerializedName("expiresInDays")
    @Expose
    public String expiresInDays;
    @SerializedName("premiumEventPrice")
    @Expose
    public Double premiumEventPrice;
    @SerializedName("eventBundlePrice")
    @Expose
    public Double eventBundlePrice;
    @SerializedName("bizPremiumEventPrice")
    @Expose
    public Double bizPremiumEventPrice;

}
