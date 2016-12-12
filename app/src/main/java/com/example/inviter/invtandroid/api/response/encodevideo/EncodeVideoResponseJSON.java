
package com.example.inviter.invtandroid.api.response.encodevideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EncodeVideoResponseJSON {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("jobData")
    @Expose
    public JobData jobData;

}
