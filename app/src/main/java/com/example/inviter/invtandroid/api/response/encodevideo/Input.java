
package com.example.inviter.invtandroid.api.response.encodevideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Input {

    @SerializedName("AspectRatio")
    @Expose
    public Object AspectRatio;
    @SerializedName("Container")
    @Expose
    public Object Container;
    @SerializedName("DetectedProperties")
    @Expose
    public Object DetectedProperties;
    @SerializedName("Encryption")
    @Expose
    public Object Encryption;
    @SerializedName("FrameRate")
    @Expose
    public Object FrameRate;
    @SerializedName("Interlaced")
    @Expose
    public Object Interlaced;
    @SerializedName("Key")
    @Expose
    public String Key;
    @SerializedName("Resolution")
    @Expose
    public Object Resolution;

}
