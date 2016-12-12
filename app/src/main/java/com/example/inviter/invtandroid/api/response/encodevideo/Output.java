
package com.example.inviter.invtandroid.api.response.encodevideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Output {

    @SerializedName("AlbumArt")
    @Expose
    public Object AlbumArt;
    @SerializedName("AppliedColorSpaceConversion")
    @Expose
    public Object AppliedColorSpaceConversion;
    @SerializedName("Captions")
    @Expose
    public Object Captions;
    @SerializedName("Composition")
    @Expose
    public List<com.example.inviter.invtandroid.api.response.encodevideo.Composition> Composition = new ArrayList<com.example.inviter.invtandroid.api.response.encodevideo.Composition>();
    @SerializedName("Duration")
    @Expose
    public Object Duration;
    @SerializedName("DurationMillis")
    @Expose
    public Object DurationMillis;
    @SerializedName("Encryption")
    @Expose
    public Object Encryption;
    @SerializedName("FileSize")
    @Expose
    public Object FileSize;
    @SerializedName("FrameRate")
    @Expose
    public Object FrameRate;
    @SerializedName("Height")
    @Expose
    public Object Height;
    @SerializedName("Id")
    @Expose
    public String Id;
    @SerializedName("Key")
    @Expose
    public String Key;
    @SerializedName("PresetId")
    @Expose
    public String PresetId;
    @SerializedName("Rotate")
    @Expose
    public Object Rotate;
    @SerializedName("SegmentDuration")
    @Expose
    public Object SegmentDuration;
    @SerializedName("Status")
    @Expose
    public String Status;
    @SerializedName("StatusDetail")
    @Expose
    public Object StatusDetail;
    @SerializedName("ThumbnailEncryption")
    @Expose
    public Object ThumbnailEncryption;
    @SerializedName("ThumbnailPattern")
    @Expose
    public String ThumbnailPattern;
    @SerializedName("Watermarks")
    @Expose
    public List<Object> Watermarks = new ArrayList<Object>();
    @SerializedName("Width")
    @Expose
    public Object Width;

}
