package com.example.inviter.invtandroid.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inwiter on 05/04/16.
 */
public class UTCDateResponseJSON {

    @SerializedName("utcDateTime")
    public String utcDate;
    @SerializedName("currentDateTime")
    public String currentDate;
    public String status;
    public String description;

    public boolean isValidDate()
    {
        if (this.status.equalsIgnoreCase("success") == true)
        {
            return true;
        }
        return false;
    }
}
