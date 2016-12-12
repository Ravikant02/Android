package com.example.inviter.invtandroid.api.response.addguest;

/**
 * Created by inviter on 7/4/16.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddGuestResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
