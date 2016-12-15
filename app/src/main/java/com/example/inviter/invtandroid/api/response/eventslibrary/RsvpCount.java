
package com.example.inviter.invtandroid.api.response.eventslibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RsvpCount {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("eventID")
    @Expose
    private String eventID;
    @SerializedName("yes")
    @Expose
    private Integer yes;
    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("mayBe")
    @Expose
    private Integer mayBe;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("totalGuests")
    @Expose
    private Integer totalGuests;
    @SerializedName("noReply")
    @Expose
    private Integer noReply;
    @SerializedName("notViewed")
    @Expose
    private Integer notViewed;
    @SerializedName("comments")
    @Expose
    private Integer comments;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public Integer getYes() {
        return yes;
    }

    public void setYes(Integer yes) {
        this.yes = yes;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getMayBe() {
        return mayBe;
    }

    public void setMayBe(Integer mayBe) {
        this.mayBe = mayBe;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(Integer totalGuests) {
        this.totalGuests = totalGuests;
    }

    public Integer getNoReply() {
        return noReply;
    }

    public void setNoReply(Integer noReply) {
        this.noReply = noReply;
    }

    public Integer getNotViewed() {
        return notViewed;
    }

    public void setNotViewed(Integer notViewed) {
        this.notViewed = notViewed;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

}
