
package com.example.inviter.invtandroid.api.response.encodevideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JobData {

    @SerializedName("Arn")
    @Expose
    public String Arn;
    @SerializedName("Id")
    @Expose
    public String Id;
    @SerializedName("Input")
    @Expose
    public com.example.inviter.invtandroid.api.response.encodevideo.Input input;
    @SerializedName("Output")
    @Expose
    public com.example.inviter.invtandroid.api.response.encodevideo.Output Output;
    @SerializedName("OutputKeyPrefix")
    @Expose
    public String OutputKeyPrefix;
    @SerializedName("Outputs")
    @Expose
    public List<Output> Outputs = new ArrayList<Output>();
    @SerializedName("PipelineId")
    @Expose
    public String PipelineId;
    @SerializedName("Playlists")
    @Expose
    public List<Object> Playlists = new ArrayList<Object>();
    @SerializedName("Status")
    @Expose
    public String Status;
    @SerializedName("Timing")
    @Expose
    public com.example.inviter.invtandroid.api.response.encodevideo.Timing Timing;
    @SerializedName("UserMetadata")
    @Expose
    public Object UserMetadata;

}
