
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Data {

    @SerializedName("userEvents")
    @Expose
    public List<UserEvent> userEvents = new ArrayList<UserEvent>();
    @SerializedName("eventsCount")
    @Expose
    public Integer eventsCount;

}
