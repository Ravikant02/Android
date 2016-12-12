
package com.example.inviter.invtandroid.api.response.encodevideojob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrigData {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("videoFile")
    @Expose
    public String videoFile;
    @SerializedName("thumbFile")
    @Expose
    public String thumbFile;

}
