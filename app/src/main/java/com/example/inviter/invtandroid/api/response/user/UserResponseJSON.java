
package com.example.inviter.invtandroid.api.response.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponseJSON {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("data")
    @Expose
    public Data data;
    @SerializedName("statusCode")
    @Expose
    public Integer statusCode;

}
