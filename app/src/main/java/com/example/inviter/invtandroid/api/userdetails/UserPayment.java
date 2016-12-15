
package com.example.inviter.invtandroid.api.userdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPayment {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("emailID")
    @Expose
    private String emailID;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("remainingEventsCount")
    @Expose
    private Integer remainingEventsCount;
    @SerializedName("customerLimit")
    @Expose
    private String customerLimit;
    @SerializedName("videoLength")
    @Expose
    private String videoLength;
    @SerializedName("videoLengthInSec")
    @Expose
    private Integer videoLengthInSec;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("paymentSchedule")
    @Expose
    private String paymentSchedule;
    @SerializedName("enrolledDate")
    @Expose
    private String enrolledDate;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("payment")
    @Expose
    private String payment;
    @SerializedName("paidBy")
    @Expose
    private String paidBy;
    @SerializedName("paidDate")
    @Expose
    private String paidDate;
    @SerializedName("expiresInDays")
    @Expose
    private String expiresInDays;
    @SerializedName("premiumEventPrice")
    @Expose
    private Double premiumEventPrice;
    @SerializedName("eventBundlePrice")
    @Expose
    private Double eventBundlePrice;
    @SerializedName("bizPremiumEventPrice")
    @Expose
    private Double bizPremiumEventPrice;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getRemainingEventsCount() {
        return remainingEventsCount;
    }

    public void setRemainingEventsCount(Integer remainingEventsCount) {
        this.remainingEventsCount = remainingEventsCount;
    }

    public String getCustomerLimit() {
        return customerLimit;
    }

    public void setCustomerLimit(String customerLimit) {
        this.customerLimit = customerLimit;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public Integer getVideoLengthInSec() {
        return videoLengthInSec;
    }

    public void setVideoLengthInSec(Integer videoLengthInSec) {
        this.videoLengthInSec = videoLengthInSec;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getExpiresInDays() {
        return expiresInDays;
    }

    public void setExpiresInDays(String expiresInDays) {
        this.expiresInDays = expiresInDays;
    }

    public Double getPremiumEventPrice() {
        return premiumEventPrice;
    }

    public void setPremiumEventPrice(Double premiumEventPrice) {
        this.premiumEventPrice = premiumEventPrice;
    }

    public Double getEventBundlePrice() {
        return eventBundlePrice;
    }

    public void setEventBundlePrice(Double eventBundlePrice) {
        this.eventBundlePrice = eventBundlePrice;
    }

    public Double getBizPremiumEventPrice() {
        return bizPremiumEventPrice;
    }

    public void setBizPremiumEventPrice(Double bizPremiumEventPrice) {
        this.bizPremiumEventPrice = bizPremiumEventPrice;
    }

}
