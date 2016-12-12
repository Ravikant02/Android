
package com.example.inviter.invtandroid.api.response.encodevideojob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("jobStatus")
    @Expose
    public String jobStatus;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("videoFile")
    @Expose
    public String videoFile;
    @SerializedName("thumbFile")
    @Expose
    public String thumbFile;
    @SerializedName("emailThumbFile")
    @Expose
    public String emailThumbFile;
    @SerializedName("cloudFrontURL")
    @Expose
    public String cloudFrontURL;

}
