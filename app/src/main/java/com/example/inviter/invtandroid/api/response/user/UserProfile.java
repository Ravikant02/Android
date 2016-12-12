
package com.example.inviter.invtandroid.api.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("userType")
    @Expose
    public String userType;
    @SerializedName("businessName")
    @Expose
    public String businessName;
    @SerializedName("businessDBA")
    @Expose
    public String businessDBA;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("middleName")
    @Expose
    public String middleName;
    @SerializedName("nickName")
    @Expose
    public String nickName;
    @SerializedName("birthday")
    @Expose
    public String birthday;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("photoName")
    @Expose
    public String photoName;
    @SerializedName("photoURL")
    @Expose
    public String photoURL;
    @SerializedName("securityLevel")
    @Expose
    public String securityLevel;
    @SerializedName("hostEmailID")
    @Expose
    public String hostEmailID;
    @SerializedName("rsvpEmailID")
    @Expose
    public String rsvpEmailID;
    @SerializedName("alternativeEmailID")
    @Expose
    public String alternativeEmailID;
    @SerializedName("hostEmailVerify")
    @Expose
    public String hostEmailVerify;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("timeZone")
    @Expose
    public String timeZone;
    @SerializedName("languageCode")
    @Expose
    public String languageCode;
    @SerializedName("countryCode")
    @Expose
    public String countryCode;
    @SerializedName("personalizedURL")
    @Expose
    public String personalizedURL;

}
