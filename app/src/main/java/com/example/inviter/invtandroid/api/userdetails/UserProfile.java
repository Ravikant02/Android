
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
     *     The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType
     *     The userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return
     *     The businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 
     * @param businessName
     *     The businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 
     * @return
     *     The businessDBA
     */
    public String getBusinessDBA() {
        return businessDBA;
    }

    /**
     * 
     * @param businessDBA
     *     The businessDBA
     */
    public void setBusinessDBA(String businessDBA) {
        this.businessDBA = businessDBA;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * 
     * @param middleName
     *     The middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * 
     * @return
     *     The nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 
     * @param nickName
     *     The nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 
     * @return
     *     The birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 
     * @param birthday
     *     The birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The photoName
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * 
     * @param photoName
     *     The photoName
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * 
     * @return
     *     The photoURL
     */
    public String getPhotoURL() {
        return photoURL;
    }

    /**
     * 
     * @param photoURL
     *     The photoURL
     */
    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    /**
     * 
     * @return
     *     The securityLevel
     */
    public String getSecurityLevel() {
        return securityLevel;
    }

    /**
     * 
     * @param securityLevel
     *     The securityLevel
     */
    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * 
     * @return
     *     The hostEmailID
     */
    public String getHostEmailID() {
        return hostEmailID;
    }

    /**
     * 
     * @param hostEmailID
     *     The hostEmailID
     */
    public void setHostEmailID(String hostEmailID) {
        this.hostEmailID = hostEmailID;
    }

    /**
     * 
     * @return
     *     The rsvpEmailID
     */
    public String getRsvpEmailID() {
        return rsvpEmailID;
    }

    /**
     * 
     * @param rsvpEmailID
     *     The rsvpEmailID
     */
    public void setRsvpEmailID(String rsvpEmailID) {
        this.rsvpEmailID = rsvpEmailID;
    }

    /**
     * 
     * @return
     *     The alternativeEmailID
     */
    public String getAlternativeEmailID() {
        return alternativeEmailID;
    }

    /**
     * 
     * @param alternativeEmailID
     *     The alternativeEmailID
     */
    public void setAlternativeEmailID(String alternativeEmailID) {
        this.alternativeEmailID = alternativeEmailID;
    }

    /**
     * 
     * @return
     *     The hostEmailVerify
     */
    public String getHostEmailVerify() {
        return hostEmailVerify;
    }

    /**
     * 
     * @param hostEmailVerify
     *     The hostEmailVerify
     */
    public void setHostEmailVerify(String hostEmailVerify) {
        this.hostEmailVerify = hostEmailVerify;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The timeZone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 
     * @return
     *     The languageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * 
     * @param languageCode
     *     The languageCode
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The personalizedURL
     */
    public String getPersonalizedURL() {
        return personalizedURL;
    }

    /**
     * 
     * @param personalizedURL
     *     The personalizedURL
     */
    public void setPersonalizedURL(String personalizedURL) {
        this.personalizedURL = personalizedURL;
    }

}
