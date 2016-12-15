
package com.example.inviter.invtandroid.api.userdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("userType")
    @Expose
    private String userType;
    @SerializedName("businessName")
    @Expose
    private String businessName;
    @SerializedName("businessDBA")
    @Expose
    private String businessDBA;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("nickName")
    @Expose
    private String nickName;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("photoName")
    @Expose
    private String photoName;
    @SerializedName("photoURL")
    @Expose
    private String photoURL;
    @SerializedName("securityLevel")
    @Expose
    private String securityLevel;
    @SerializedName("hostEmailID")
    @Expose
    private String hostEmailID;
    @SerializedName("rsvpEmailID")
    @Expose
    private String rsvpEmailID;
    @SerializedName("alternativeEmailID")
    @Expose
    private String alternativeEmailID;
    @SerializedName("hostEmailVerify")
    @Expose
    private String hostEmailVerify;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("languageCode")
    @Expose
    private String languageCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("personalizedURL")
    @Expose
    private String personalizedURL;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDBA() {
        return businessDBA;
    }

    public void setBusinessDBA(String businessDBA) {
        this.businessDBA = businessDBA;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getHostEmailID() {
        return hostEmailID;
    }

    public void setHostEmailID(String hostEmailID) {
        this.hostEmailID = hostEmailID;
    }

    public String getRsvpEmailID() {
        return rsvpEmailID;
    }

    public void setRsvpEmailID(String rsvpEmailID) {
        this.rsvpEmailID = rsvpEmailID;
    }

    public String getAlternativeEmailID() {
        return alternativeEmailID;
    }

    public void setAlternativeEmailID(String alternativeEmailID) {
        this.alternativeEmailID = alternativeEmailID;
    }

    public String getHostEmailVerify() {
        return hostEmailVerify;
    }

    public void setHostEmailVerify(String hostEmailVerify) {
        this.hostEmailVerify = hostEmailVerify;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPersonalizedURL() {
        return personalizedURL;
    }

    public void setPersonalizedURL(String personalizedURL) {
        this.personalizedURL = personalizedURL;
    }

}
