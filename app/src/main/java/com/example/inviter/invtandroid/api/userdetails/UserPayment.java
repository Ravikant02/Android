
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
     *     The emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * 
     * @param emailID
     *     The emailID
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * 
     * @return
     *     The paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 
     * @param paymentType
     *     The paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 
     * @return
     *     The remainingEventsCount
     */
    public Integer getRemainingEventsCount() {
        return remainingEventsCount;
    }

    /**
     * 
     * @param remainingEventsCount
     *     The remainingEventsCount
     */
    public void setRemainingEventsCount(Integer remainingEventsCount) {
        this.remainingEventsCount = remainingEventsCount;
    }

    /**
     * 
     * @return
     *     The customerLimit
     */
    public String getCustomerLimit() {
        return customerLimit;
    }

    /**
     * 
     * @param customerLimit
     *     The customerLimit
     */
    public void setCustomerLimit(String customerLimit) {
        this.customerLimit = customerLimit;
    }

    /**
     * 
     * @return
     *     The videoLength
     */
    public String getVideoLength() {
        return videoLength;
    }

    /**
     * 
     * @param videoLength
     *     The videoLength
     */
    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    /**
     * 
     * @return
     *     The videoLengthInSec
     */
    public Integer getVideoLengthInSec() {
        return videoLengthInSec;
    }

    /**
     * 
     * @param videoLengthInSec
     *     The videoLengthInSec
     */
    public void setVideoLengthInSec(Integer videoLengthInSec) {
        this.videoLengthInSec = videoLengthInSec;
    }

    /**
     * 
     * @return
     *     The paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 
     * @param paymentStatus
     *     The paymentStatus
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * 
     * @return
     *     The paymentSchedule
     */
    public String getPaymentSchedule() {
        return paymentSchedule;
    }

    /**
     * 
     * @param paymentSchedule
     *     The paymentSchedule
     */
    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    /**
     * 
     * @return
     *     The enrolledDate
     */
    public String getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * 
     * @param enrolledDate
     *     The enrolledDate
     */
    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    /**
     * 
     * @return
     *     The expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * 
     * @param expiryDate
     *     The expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * 
     * @return
     *     The payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 
     * @param payment
     *     The payment
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * 
     * @return
     *     The paidBy
     */
    public String getPaidBy() {
        return paidBy;
    }

    /**
     * 
     * @param paidBy
     *     The paidBy
     */
    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    /**
     * 
     * @return
     *     The paidDate
     */
    public String getPaidDate() {
        return paidDate;
    }

    /**
     * 
     * @param paidDate
     *     The paidDate
     */
    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * 
     * @return
     *     The expiresInDays
     */
    public String getExpiresInDays() {
        return expiresInDays;
    }

    /**
     * 
     * @param expiresInDays
     *     The expiresInDays
     */
    public void setExpiresInDays(String expiresInDays) {
        this.expiresInDays = expiresInDays;
    }

    /**
     * 
     * @return
     *     The premiumEventPrice
     */
    public Double getPremiumEventPrice() {
        return premiumEventPrice;
    }

    /**
     * 
     * @param premiumEventPrice
     *     The premiumEventPrice
     */
    public void setPremiumEventPrice(Double premiumEventPrice) {
        this.premiumEventPrice = premiumEventPrice;
    }

    /**
     * 
     * @return
     *     The eventBundlePrice
     */
    public Double getEventBundlePrice() {
        return eventBundlePrice;
    }

    /**
     * 
     * @param eventBundlePrice
     *     The eventBundlePrice
     */
    public void setEventBundlePrice(Double eventBundlePrice) {
        this.eventBundlePrice = eventBundlePrice;
    }

    /**
     * 
     * @return
     *     The bizPremiumEventPrice
     */
    public Double getBizPremiumEventPrice() {
        return bizPremiumEventPrice;
    }

    /**
     * 
     * @param bizPremiumEventPrice
     *     The bizPremiumEventPrice
     */
    public void setBizPremiumEventPrice(Double bizPremiumEventPrice) {
        this.bizPremiumEventPrice = bizPremiumEventPrice;
    }

}
