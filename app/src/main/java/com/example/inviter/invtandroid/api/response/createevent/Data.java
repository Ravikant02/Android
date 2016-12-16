package com.example.inviter.invtandroid.api.response.createevent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ravikant on 16/12/16.
 */

public class Data {
    @SerializedName("eventID")
    @Expose
    private String eventID;
    @SerializedName("guestURL")
    @Expose
    private String guestURL;

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getGuestURL() {
        return guestURL;
    }

    public void setGuestURL(String guestURL) {
        this.guestURL = guestURL;
    }
}
