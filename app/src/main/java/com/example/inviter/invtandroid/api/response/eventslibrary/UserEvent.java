
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserEvent {

    @SerializedName("eventInfo")
    @Expose
    public EventInfo eventInfo;
    @SerializedName("rsvpCount")
    @Expose
    public RsvpCount rsvpCount;
    @SerializedName("socialCount")
    @Expose
    public String socialCount;
    @SerializedName("guestList")
    @Expose
    public String guestList;

}
