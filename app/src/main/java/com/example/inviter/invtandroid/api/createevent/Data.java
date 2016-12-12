package com.example.inviter.invtandroid.api.createevent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ravikant on 10/12/16.
 */

public class Data {
        @SerializedName("eventID")
        @Expose
        private String eventID;
        @SerializedName("guestURL")
        @Expose
        private String guestURL;

        /**
         *
         * @return
         * The eventID
         */
        public String getEventID() {
            return eventID;
        }

        /**
         *
         * @param eventID
         * The eventID
         */
        public void setEventID(String eventID) {
            this.eventID = eventID;
        }

        /**
         *
         * @return
         * The guestURL
         */
        public String getGuestURL() {
            return guestURL;
        }

        /**
         *
         * @param guestURL
         * The guestURL
         */
        public void setGuestURL(String guestURL) {
            this.guestURL = guestURL;
        }
}
