
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserEvent {

    @SerializedName("eventInfo")
    @Expose
    private EventInfo eventInfo;
    @SerializedName("rsvpCount")
    @Expose
    private RsvpCount rsvpCount;
    @SerializedName("socialCount")
    @Expose
    private String socialCount;
    @SerializedName("guestList")
    @Expose
    private String guestList;

    public EventInfo getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfo eventInfo) {
        this.eventInfo = eventInfo;
    }

    public RsvpCount getRsvpCount() {
        return rsvpCount;
    }

    public void setRsvpCount(RsvpCount rsvpCount) {
        this.rsvpCount = rsvpCount;
    }

    public String getSocialCount() {
        return socialCount;
    }

    public void setSocialCount(String socialCount) {
        this.socialCount = socialCount;
    }

    public String getGuestList() {
        return guestList;
    }

    public void setGuestList(String guestList) {
        this.guestList = guestList;
    }

}
