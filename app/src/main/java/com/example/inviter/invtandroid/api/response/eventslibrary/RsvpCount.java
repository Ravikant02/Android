
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RsvpCount {

    @SerializedName("userID")
    @Expose
    public String userID;
    @SerializedName("eventID")
    @Expose
    public String eventID;
    @SerializedName("yes")
    @Expose
    public Integer yes;
    @SerializedName("no")
    @Expose
    public Integer no;
    @SerializedName("mayBe")
    @Expose
    public Integer mayBe;
    @SerializedName("views")
    @Expose
    public Integer views;
    @SerializedName("totalGuests")
    @Expose
    public Integer totalGuests;
    @SerializedName("noReply")
    @Expose
    public Integer noReply;
    @SerializedName("notViewed")
    @Expose
    public Integer notViewed;
    @SerializedName("comments")
    @Expose
    public Integer comments;

}
