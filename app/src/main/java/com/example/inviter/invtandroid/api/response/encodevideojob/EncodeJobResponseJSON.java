
package com.example.inviter.invtandroid.api.response.encodevideojob;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EncodeJobResponseJSON {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("indexVal")
    @Expose
    public String indexVal;
    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("origData")
    @Expose
    public OrigData origData;

}
