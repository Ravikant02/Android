
package com.example.inviter.invtandroid.api.response.encodevideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timing {

    @SerializedName("FinishTimeMillis")
    @Expose
    public Object FinishTimeMillis;
    @SerializedName("StartTimeMillis")
    @Expose
    public Object StartTimeMillis;
//    @SerializedName("SubmitTimeMillis")
//    @Expose
//    public Integer SubmitTimeMillis;

}
