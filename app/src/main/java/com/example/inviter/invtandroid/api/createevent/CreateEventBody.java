package com.example.inviter.invtandroid.api.createevent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mymac on 10/12/16.
 */

public class CreateEventBody {

        @SerializedName("appType")
        @Expose
        private String appType;
        @SerializedName("eventHostEmail")
        @Expose
        private String eventHostEmail;
        @SerializedName("eventHostName")
        @Expose
        private String eventHostName;
        @SerializedName("eventTimezoneOffset")
        @Expose
        private String eventTimezoneOffset;
        @SerializedName("eventTitle")
        @Expose
        private String eventTitle;
        @SerializedName("eventType")
        @Expose
        private String eventType;
        @SerializedName("eventStartDate")
        @Expose
        private String eventStartDate;
        @SerializedName("eventStartTime")
        @Expose
        private String eventStartTime;
        @SerializedName("eventEndDate")
        @Expose
        private String eventEndDate;
        @SerializedName("eventEndTime")
        @Expose
        private String eventEndTime;
        @SerializedName("eventVenue")
        @Expose
        private String eventVenue;
        @SerializedName("uploadMediaType")
        @Expose
        private String uploadMediaType;
        @SerializedName("videoFileURL")
        @Expose
        private String videoFileURL;
        @SerializedName("videoThumbURL")
        @Expose
        private String videoThumbURL;
        @SerializedName("emailThumbURL")
        @Expose
        private String emailThumbURL;
        @SerializedName("invitationCards")
        @Expose
        private List<String> invitationCards = null;

        /**
         *
         * @return
         * The appType
         */
        public String getAppType() {
            return appType;
        }

        /**
         *
         * @param appType
         * The appType
         */
        public void setAppType(String appType) {
            this.appType = appType;
        }

        /**
         *
         * @return
         * The eventHostEmail
         */
        public String getEventHostEmail() {
            return eventHostEmail;
        }

        /**
         *
         * @param eventHostEmail
         * The eventHostEmail
         */
        public void setEventHostEmail(String eventHostEmail) {
            this.eventHostEmail = eventHostEmail;
        }

        /**
         *
         * @return
         * The eventHostName
         */
        public String getEventHostName() {
            return eventHostName;
        }

        /**
         *
         * @param eventHostName
         * The eventHostName
         */
        public void setEventHostName(String eventHostName) {
            this.eventHostName = eventHostName;
        }

        /**
         *
         * @return
         * The eventTimezoneOffset
         */
        public String getEventTimezoneOffset() {
            return eventTimezoneOffset;
        }

        /**
         *
         * @param eventTimezoneOffset
         * The eventTimezoneOffset
         */
        public void setEventTimezoneOffset(String eventTimezoneOffset) {
            this.eventTimezoneOffset = eventTimezoneOffset;
        }

        /**
         *
         * @return
         * The eventTitle
         */
        public String getEventTitle() {
            return eventTitle;
        }

        /**
         *
         * @param eventTitle
         * The eventTitle
         */
        public void setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
        }

        /**
         *
         * @return
         * The eventType
         */
        public String getEventType() {
            return eventType;
        }

        /**
         *
         * @param eventType
         * The eventType
         */
        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        /**
         *
         * @return
         * The eventStartDate
         */
        public String getEventStartDate() {
            return eventStartDate;
        }

        /**
         *
         * @param eventStartDate
         * The eventStartDate
         */
        public void setEventStartDate(String eventStartDate) {
            this.eventStartDate = eventStartDate;
        }

        /**
         *
         * @return
         * The eventStartTime
         */
        public String getEventStartTime() {
            return eventStartTime;
        }

        /**
         *
         * @param eventStartTime
         * The eventStartTime
         */
        public void setEventStartTime(String eventStartTime) {
            this.eventStartTime = eventStartTime;
        }

        /**
         *
         * @return
         * The eventEndDate
         */
        public String getEventEndDate() {
            return eventEndDate;
        }

        /**
         *
         * @param eventEndDate
         * The eventEndDate
         */
        public void setEventEndDate(String eventEndDate) {
            this.eventEndDate = eventEndDate;
        }

        /**
         *
         * @return
         * The eventEndTime
         */
        public String getEventEndTime() {
            return eventEndTime;
        }

        /**
         *
         * @param eventEndTime
         * The eventEndTime
         */
        public void setEventEndTime(String eventEndTime) {
            this.eventEndTime = eventEndTime;
        }

        /**
         *
         * @return
         * The eventVenue
         */
        public String getEventVenue() {
            return eventVenue;
        }

        /**
         *
         * @param eventVenue
         * The eventVenue
         */
        public void setEventVenue(String eventVenue) {
            this.eventVenue = eventVenue;
        }

        /**
         *
         * @return
         * The uploadMediaType
         */
        public String getUploadMediaType() {
            return uploadMediaType;
        }

        /**
         *
         * @param uploadMediaType
         * The uploadMediaType
         */
        public void setUploadMediaType(String uploadMediaType) {
            this.uploadMediaType = uploadMediaType;
        }

        /**
         *
         * @return
         * The videoFileURL
         */
        public String getVideoFileURL() {
            return videoFileURL;
        }

        /**
         *
         * @param videoFileURL
         * The videoFileURL
         */
        public void setVideoFileURL(String videoFileURL) {
            this.videoFileURL = videoFileURL;
        }

        /**
         *
         * @return
         * The videoThumbURL
         */
        public String getVideoThumbURL() {
            return videoThumbURL;
        }

        /**
         *
         * @param videoThumbURL
         * The videoThumbURL
         */
        public void setVideoThumbURL(String videoThumbURL) {
            this.videoThumbURL = videoThumbURL;
        }

        /**
         *
         * @return
         * The emailThumbURL
         */
        public String getEmailThumbURL() {
            return emailThumbURL;
        }

        /**
         *
         * @param emailThumbURL
         * The emailThumbURL
         */
        public void setEmailThumbURL(String emailThumbURL) {
            this.emailThumbURL = emailThumbURL;
        }

        /**
         *
         * @return
         * The invitationCards
         */
        public List<String> getInvitationCards() {
            return invitationCards;
        }

        /**
         *
         * @param invitationCards
         * The invitationCards
         */
        public void setInvitationCards(List<String> invitationCards) {
            this.invitationCards = invitationCards;
        }
}
