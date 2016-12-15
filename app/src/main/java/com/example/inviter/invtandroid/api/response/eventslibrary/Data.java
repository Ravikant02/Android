
package com.example.inviter.invtandroid.api.response.eventslibrary;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("userEvents")
    @Expose
    private List<UserEvent> userEvents = null;
    @SerializedName("eventsCount")
    @Expose
    private Integer eventsCount;

    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> userEvents) {
        this.userEvents = userEvents;
    }

    public Integer getEventsCount() {
        return eventsCount;
    }

    public void setEventsCount(Integer eventsCount) {
        this.eventsCount = eventsCount;
    }

}
