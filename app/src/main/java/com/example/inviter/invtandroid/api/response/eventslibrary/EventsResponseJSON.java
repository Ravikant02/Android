
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EventsResponseJSON {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("eventRequestType")
    @Expose
    public String eventRequestType;
    @SerializedName("data")
    @Expose
    public Data data;

}
