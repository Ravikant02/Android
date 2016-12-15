
package com.example.inviter.invtandroid.api.response.eventslibrary;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventInfo {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("eventID")
    @Expose
    private String eventID;
    @SerializedName("isPublicEvent")
    @Expose
    private String isPublicEvent;
    @SerializedName("enableRSVP")
    @Expose
    private String enableRSVP;
    @SerializedName("isPastEvent")
    @Expose
    private Boolean isPastEvent;
    @SerializedName("scheduledOption")
    @Expose
    private String scheduledOption;
    @SerializedName("eventEndDate")
    @Expose
    private String eventEndDate;
    @SerializedName("eventEndTime")
    @Expose
    private String eventEndTime;
    @SerializedName("eventJobDefinitionID")
    @Expose
    private String eventJobDefinitionID;
    @SerializedName("eventJobRequestID")
    @Expose
    private String eventJobRequestID;
    @SerializedName("eventScheduledDate")
    @Expose
    private String eventScheduledDate;
    @SerializedName("eventScheduledTime")
    @Expose
    private String eventScheduledTime;
    @SerializedName("eventStartDate")
    @Expose
    private String eventStartDate;
    @SerializedName("eventStartTime")
    @Expose
    private String eventStartTime;
    @SerializedName("Browser")
    @Expose
    private String browser;
    @SerializedName("eventCategory")
    @Expose
    private String eventCategory;
    @SerializedName("eventDescription")
    @Expose
    private String eventDescription;
    @SerializedName("appType")
    @Expose
    private String appType;
    @SerializedName("eventGuestThemeURL")
    @Expose
    private String eventGuestThemeURL;
    @SerializedName("eventHostEmail")
    @Expose
    private String eventHostEmail;
    @SerializedName("eventHostName")
    @Expose
    private String eventHostName;
    @SerializedName("eventHostPhone")
    @Expose
    private String eventHostPhone;
    @SerializedName("eventHostPhotoURL")
    @Expose
    private String eventHostPhotoURL;
    @SerializedName("languageCode")
    @Expose
    private String languageCode;
    @SerializedName("eventStatus")
    @Expose
    private String eventStatus;
    @SerializedName("eventTimezoneOffset")
    @Expose
    private String eventTimezoneOffset;
    @SerializedName("eventTitle")
    @Expose
    private String eventTitle;
    @SerializedName("eventType")
    @Expose
    private String eventType;
    @SerializedName("eventVenue")
    @Expose
    private String eventVenue;
    @SerializedName("uploadMediaType")
    @Expose
    private String uploadMediaType;
    @SerializedName("invitationCards")
    @Expose
    private List<Object> invitationCards = null;
    @SerializedName("videoFileURL")
    @Expose
    private String videoFileURL;
    @SerializedName("videoThumbURL")
    @Expose
    private String videoThumbURL;
    @SerializedName("emailThumbURL")
    @Expose
    private String emailThumbURL;
    @SerializedName("videoLargeThumbURL")
    @Expose
    private String videoLargeThumbURL;
    @SerializedName("editEventURL")
    @Expose
    private String editEventURL;
    @SerializedName("previewEventURL")
    @Expose
    private String previewEventURL;
    @SerializedName("guestURL")
    @Expose
    private String guestURL;
    @SerializedName("copyEventURL")
    @Expose
    private String copyEventURL;
    @SerializedName("addGuestsURL")
    @Expose
    private String addGuestsURL;
    @SerializedName("activityReportURL")
    @Expose
    private String activityReportURL;
    @SerializedName("eventReminderURL")
    @Expose
    private String eventReminderURL;
    @SerializedName("upgradeGuestLimitURL")
    @Expose
    private String upgradeGuestLimitURL;
    @SerializedName("RSVPEmail")
    @Expose
    private String rSVPEmail;
    @SerializedName("shareURL")
    @Expose
    private String shareURL;
    @SerializedName("personalizedURL")
    @Expose
    private String personalizedURL;
    @SerializedName("hashTag")
    @Expose
    private String hashTag;
    @SerializedName("DBA")
    @Expose
    private String dBA;
    @SerializedName("isCustomEmailTemplate")
    @Expose
    private String isCustomEmailTemplate;
    @SerializedName("emailTemplateName")
    @Expose
    private String emailTemplateName;
    @SerializedName("isCustomEmailSubject")
    @Expose
    private String isCustomEmailSubject;
    @SerializedName("emailSubject")
    @Expose
    private String emailSubject;
    @SerializedName("isCustomGuestTemplate")
    @Expose
    private String isCustomGuestTemplate;
    @SerializedName("guestTemplateName")
    @Expose
    private String guestTemplateName;
    @SerializedName("guestTemplateID")
    @Expose
    private String guestTemplateID;
    @SerializedName("userPaymentType")
    @Expose
    private String userPaymentType;
    @SerializedName("eventGuestLimit")
    @Expose
    private String eventGuestLimit;
    @SerializedName("eventVideoLength")
    @Expose
    private String eventVideoLength;
    @SerializedName("emailFromName")
    @Expose
    private String emailFromName;
    @SerializedName("RSVPByDate")
    @Expose
    private String rSVPByDate;
    @SerializedName("attire")
    @Expose
    private String attire;
    @SerializedName("otherEventsCount")
    @Expose
    private Integer otherEventsCount;
    @SerializedName("groomName")
    @Expose
    private String groomName;
    @SerializedName("brideName")
    @Expose
    private String brideName;

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

    public String getIsPublicEvent() {
        return isPublicEvent;
    }

    public void setIsPublicEvent(String isPublicEvent) {
        this.isPublicEvent = isPublicEvent;
    }

    public String getEnableRSVP() {
        return enableRSVP;
    }

    public void setEnableRSVP(String enableRSVP) {
        this.enableRSVP = enableRSVP;
    }

    public Boolean getIsPastEvent() {
        return isPastEvent;
    }

    public void setIsPastEvent(Boolean isPastEvent) {
        this.isPastEvent = isPastEvent;
    }

    public String getScheduledOption() {
        return scheduledOption;
    }

    public void setScheduledOption(String scheduledOption) {
        this.scheduledOption = scheduledOption;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventJobDefinitionID() {
        return eventJobDefinitionID;
    }

    public void setEventJobDefinitionID(String eventJobDefinitionID) {
        this.eventJobDefinitionID = eventJobDefinitionID;
    }

    public String getEventJobRequestID() {
        return eventJobRequestID;
    }

    public void setEventJobRequestID(String eventJobRequestID) {
        this.eventJobRequestID = eventJobRequestID;
    }

    public String getEventScheduledDate() {
        return eventScheduledDate;
    }

    public void setEventScheduledDate(String eventScheduledDate) {
        this.eventScheduledDate = eventScheduledDate;
    }

    public String getEventScheduledTime() {
        return eventScheduledTime;
    }

    public void setEventScheduledTime(String eventScheduledTime) {
        this.eventScheduledTime = eventScheduledTime;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getEventGuestThemeURL() {
        return eventGuestThemeURL;
    }

    public void setEventGuestThemeURL(String eventGuestThemeURL) {
        this.eventGuestThemeURL = eventGuestThemeURL;
    }

    public String getEventHostEmail() {
        return eventHostEmail;
    }

    public void setEventHostEmail(String eventHostEmail) {
        this.eventHostEmail = eventHostEmail;
    }

    public String getEventHostName() {
        return eventHostName;
    }

    public void setEventHostName(String eventHostName) {
        this.eventHostName = eventHostName;
    }

    public String getEventHostPhone() {
        return eventHostPhone;
    }

    public void setEventHostPhone(String eventHostPhone) {
        this.eventHostPhone = eventHostPhone;
    }

    public String getEventHostPhotoURL() {
        return eventHostPhotoURL;
    }

    public void setEventHostPhotoURL(String eventHostPhotoURL) {
        this.eventHostPhotoURL = eventHostPhotoURL;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventTimezoneOffset() {
        return eventTimezoneOffset;
    }

    public void setEventTimezoneOffset(String eventTimezoneOffset) {
        this.eventTimezoneOffset = eventTimezoneOffset;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getUploadMediaType() {
        return uploadMediaType;
    }

    public void setUploadMediaType(String uploadMediaType) {
        this.uploadMediaType = uploadMediaType;
    }

    public List<Object> getInvitationCards() {
        return invitationCards;
    }

    public void setInvitationCards(List<Object> invitationCards) {
        this.invitationCards = invitationCards;
    }

    public String getVideoFileURL() {
        return videoFileURL;
    }

    public void setVideoFileURL(String videoFileURL) {
        this.videoFileURL = videoFileURL;
    }

    public String getVideoThumbURL() {
        return videoThumbURL;
    }

    public void setVideoThumbURL(String videoThumbURL) {
        this.videoThumbURL = videoThumbURL;
    }

    public String getEmailThumbURL() {
        return emailThumbURL;
    }

    public void setEmailThumbURL(String emailThumbURL) {
        this.emailThumbURL = emailThumbURL;
    }

    public String getVideoLargeThumbURL() {
        return videoLargeThumbURL;
    }

    public void setVideoLargeThumbURL(String videoLargeThumbURL) {
        this.videoLargeThumbURL = videoLargeThumbURL;
    }

    public String getEditEventURL() {
        return editEventURL;
    }

    public void setEditEventURL(String editEventURL) {
        this.editEventURL = editEventURL;
    }

    public String getPreviewEventURL() {
        return previewEventURL;
    }

    public void setPreviewEventURL(String previewEventURL) {
        this.previewEventURL = previewEventURL;
    }

    public String getGuestURL() {
        return guestURL;
    }

    public void setGuestURL(String guestURL) {
        this.guestURL = guestURL;
    }

    public String getCopyEventURL() {
        return copyEventURL;
    }

    public void setCopyEventURL(String copyEventURL) {
        this.copyEventURL = copyEventURL;
    }

    public String getAddGuestsURL() {
        return addGuestsURL;
    }

    public void setAddGuestsURL(String addGuestsURL) {
        this.addGuestsURL = addGuestsURL;
    }

    public String getActivityReportURL() {
        return activityReportURL;
    }

    public void setActivityReportURL(String activityReportURL) {
        this.activityReportURL = activityReportURL;
    }

    public String getEventReminderURL() {
        return eventReminderURL;
    }

    public void setEventReminderURL(String eventReminderURL) {
        this.eventReminderURL = eventReminderURL;
    }

    public String getUpgradeGuestLimitURL() {
        return upgradeGuestLimitURL;
    }

    public void setUpgradeGuestLimitURL(String upgradeGuestLimitURL) {
        this.upgradeGuestLimitURL = upgradeGuestLimitURL;
    }

    public String getRSVPEmail() {
        return rSVPEmail;
    }

    public void setRSVPEmail(String rSVPEmail) {
        this.rSVPEmail = rSVPEmail;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public String getPersonalizedURL() {
        return personalizedURL;
    }

    public void setPersonalizedURL(String personalizedURL) {
        this.personalizedURL = personalizedURL;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public String getDBA() {
        return dBA;
    }

    public void setDBA(String dBA) {
        this.dBA = dBA;
    }

    public String getIsCustomEmailTemplate() {
        return isCustomEmailTemplate;
    }

    public void setIsCustomEmailTemplate(String isCustomEmailTemplate) {
        this.isCustomEmailTemplate = isCustomEmailTemplate;
    }

    public String getEmailTemplateName() {
        return emailTemplateName;
    }

    public void setEmailTemplateName(String emailTemplateName) {
        this.emailTemplateName = emailTemplateName;
    }

    public String getIsCustomEmailSubject() {
        return isCustomEmailSubject;
    }

    public void setIsCustomEmailSubject(String isCustomEmailSubject) {
        this.isCustomEmailSubject = isCustomEmailSubject;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getIsCustomGuestTemplate() {
        return isCustomGuestTemplate;
    }

    public void setIsCustomGuestTemplate(String isCustomGuestTemplate) {
        this.isCustomGuestTemplate = isCustomGuestTemplate;
    }

    public String getGuestTemplateName() {
        return guestTemplateName;
    }

    public void setGuestTemplateName(String guestTemplateName) {
        this.guestTemplateName = guestTemplateName;
    }

    public String getGuestTemplateID() {
        return guestTemplateID;
    }

    public void setGuestTemplateID(String guestTemplateID) {
        this.guestTemplateID = guestTemplateID;
    }

    public String getUserPaymentType() {
        return userPaymentType;
    }

    public void setUserPaymentType(String userPaymentType) {
        this.userPaymentType = userPaymentType;
    }

    public String getEventGuestLimit() {
        return eventGuestLimit;
    }

    public void setEventGuestLimit(String eventGuestLimit) {
        this.eventGuestLimit = eventGuestLimit;
    }

    public String getEventVideoLength() {
        return eventVideoLength;
    }

    public void setEventVideoLength(String eventVideoLength) {
        this.eventVideoLength = eventVideoLength;
    }

    public String getEmailFromName() {
        return emailFromName;
    }

    public void setEmailFromName(String emailFromName) {
        this.emailFromName = emailFromName;
    }

    public String getRSVPByDate() {
        return rSVPByDate;
    }

    public void setRSVPByDate(String rSVPByDate) {
        this.rSVPByDate = rSVPByDate;
    }

    public String getAttire() {
        return attire;
    }

    public void setAttire(String attire) {
        this.attire = attire;
    }

    public Integer getOtherEventsCount() {
        return otherEventsCount;
    }

    public void setOtherEventsCount(Integer otherEventsCount) {
        this.otherEventsCount = otherEventsCount;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

}
