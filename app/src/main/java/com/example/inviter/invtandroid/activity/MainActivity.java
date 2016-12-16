package com.example.inviter.invtandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.adapters.EventsAdapter;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.response.createevent.CreateEvent;
import com.example.inviter.invtandroid.api.response.eventslibrary.EventLibrary;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.listEvents) ListView listEvents;
    private String userID;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView txtTitle = (TextView) toolbar.findViewById(R.id.txtTitle);
        txtTitle.setText("Events");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/


       /* Drawable drawable = getResources().getDrawable(R.drawable.circular_rsvp_yes);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressRsvpYes);
        //mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        int totalGuest = 58;
        int yesGuest = 36;
        int rsvpYes = (yesGuest * 100) / totalGuest;
        mProgress.setProgress(rsvpYes);
        tv = (TextView) findViewById(R.id.txtThankYou);
        tv.setText(rsvpYes+"");*/
        /*new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(100); //thread will take approx 1.5 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/
        sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        userID = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_USER_ID, "");
        getAllEvents();
        /*String jsonString = "{\"status\":\"success\",\"description\":\"Data retrieved successfully\",\"eventRequestType\":\"all\",\"data\":{\"userEvents\":[{\"eventInfo\":{\"userID\":\"f457c545a9ded88f18ecee47145a72c0\",\"eventID\":\"15e122e839dfdaa7ce969536f94aecf6\",\"isPublicEvent\":\"0\",\"enableRSVP\":\"1\",\"isPastEvent\":false,\"scheduledOption\":\"1\",\"eventEndDate\":\"2017-11-15\",\"eventEndTime\":\"12:48:53\",\"eventJobDefinitionID\":\"\",\"eventJobRequestID\":\"\",\"eventScheduledDate\":\"2016-12-13\",\"eventScheduledTime\":\"08:55\",\"eventStartDate\":\"2017-11-14\",\"eventStartTime\":\"12:48:53\",\"Browser\":\"Chrome 54/Linux x86_64\",\"eventCategory\":\"Anniversary\",\"eventDescription\":\"\",\"appType\":\"0\",\"eventGuestThemeURL\":\"/storage/usermedia/designs/backgrounds/business/black-dots.jpg\",\"eventHostEmail\":\"madhukudala@inviter.com\",\"eventHostName\":\"Madhu Kudala\",\"eventHostPhone\":\"\",\"eventHostPhotoURL\":\"public/images/user-dummy.jpg\",\"languageCode\":\"en\",\"eventStatus\":\"SB\",\"eventTimezoneOffset\":\"-05:00_Eastern Time [US & Canada]\",\"eventTitle\":\"About text bug\",\"eventType\":\"1\",\"eventVenue\":\"Cyber Towers, Hitech city, Hyderabad, India 500081\",\"uploadMediaType\":\"0\",\"invitationCards\":[],\"videoFileURL\":\"https://d2j259rizy5u5h.cloudfront.net/\",\"videoThumbURL\":\"https://d2j259rizy5u5h.cloudfront.net/videoeditor/images/2016_02_11_10_09_02_56bc10664c9c5.jpg?1455165545342\",\"emailThumbURL\":\"\",\"videoLargeThumbURL\":\"\",\"editEventURL\":\"http://localhost/createevent/edit/15e122e839dfdaa7ce969536f94aecf6\",\"previewEventURL\":\"http://localhost/rd/b1bVs\",\"guestURL\":\"\",\"copyEventURL\":\"http://localhost/createevent/copy/15e122e839dfdaa7ce969536f94aecf6\",\"addGuestsURL\":\"http://localhost/addinvitees/15e122e839dfdaa7ce969536f94aecf6\",\"activityReportURL\":\"http://localhost/activityreport/f457c545a9ded88f18ecee47145a72c0/15e122e839dfdaa7ce969536f94aecf6\",\"eventReminderURL\":\"http://localhost/sendreminder/15e122e839dfdaa7ce969536f94aecf6\",\"upgradeGuestLimitURL\":\"http://localhost/upgradeeventguestlimit/15e122e839dfdaa7ce969536f94aecf6\",\"RSVPEmail\":\"\",\"shareURL\":\"http://localhost/rd/b1bVs\",\"personalizedURL\":\"http://localhost/rd/b1bVs\",\"hashTag\":\"\",\"DBA\":\"event\",\"isCustomEmailTemplate\":\"0\",\"emailTemplateName\":\"dflt_mail_biz_event_tmplt.html\",\"isCustomEmailSubject\":\"0\",\"emailSubject\":\"\",\"isCustomGuestTemplate\":\"0\",\"guestTemplateName\":\"guestTemplate_11473\",\"guestTemplateID\":\"OTH001\",\"userPaymentType\":\"Premium Event\",\"eventGuestLimit\":\"25\",\"eventVideoLength\":\"00:05:00\",\"emailFromName\":\"\",\"RSVPByDate\":\"\",\"attire\":\"\",\"otherEventsCount\":0,\"groomName\":\"\",\"brideName\":\"\"},\"rsvpCount\":{\"userID\":\"f457c545a9ded88f18ecee47145a72c0\",\"eventID\":\"15e122e839dfdaa7ce969536f94aecf6\",\"yes\":180,\"no\":30,\"mayBe\":40,\"views\":0,\"totalGuests\":250,\"noReply\":4,\"notViewed\":4,\"comments\":0},\"socialCount\":\"\",\"guestList\":\"\"},{\"eventInfo\":{\"userID\":\"f457c545a9ded88f18ecee47145a72c0\",\"eventID\":\"ba036d228858d76fb89189853a5503bd\",\"isPublicEvent\":\"1\",\"enableRSVP\":\"1\",\"isPastEvent\":false,\"scheduledOption\":\"1\",\"eventEndDate\":\"2017-05-05\",\"eventEndTime\":\"10:05:00\",\"eventJobDefinitionID\":\"\",\"eventJobRequestID\":\"\",\"eventScheduledDate\":\"2016-12-13\",\"eventScheduledTime\":\"08:55\",\"eventStartDate\":\"2017-05-03\",\"eventStartTime\":\"10:00:00\",\"Browser\":\"Chrome 54/Linux x86_64\",\"eventCategory\":\"Wedding\",\"eventDescription\":\"<p><iframe frameborder='0' src='//www.youtube.com/embed/uasB6VKh8_E' width='640' height='360' class='note-video-clip'></iframe><br></p><p><br></p><p><br></p><p><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'>So you are saying that on the guest page, after the event title, the image should be displayed and then the video should be displayed?</font></span></strong></span></p><p><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'>dsafndsfg.s,dmagnf,s.dmfgn<br>sdfkgb.,bsfg</font></span></strong></span></p><p><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'>kjsdbgfksdfjbg</font></span></strong></span></p><p><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'><br></font></span></strong></span></p><p><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'><br></font></span></strong></span></p><p><span style='font-size:20px'><strong><span style='font-family: &quot;times new roman&quot;, times, serif;'><font color='#424242'>sadkdjsgkas;dgkl;sadgh;lhsdjsdlkjfglkjs&nbsp;</font></span></strong></span><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'></p><p><br></p><p><br></p><p><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'></p><hr><p><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'></p><p><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'></p><hr><p><img src='https://inviter.com/public/images/inviter-logo1.png' style='width: 150px;'></p><p><br></p><hr><p><br></p><hr><p><br></p><hr><p><br></p><hr><p><br></p>\",\"appType\":\"0\",\"eventGuestThemeURL\":\"/public/images/wedding-background2.jpg\",\"eventHostEmail\":\"madhukudala@inviter.com\",\"eventHostName\":\"Madhu Kudala\",\"eventHostPhone\":\"\",\"eventHostPhotoURL\":\"public/images/user-dummy.jpg\",\"languageCode\":\"en\",\"eventStatus\":\"DR\",\"eventTimezoneOffset\":\"+05:30_Chennai, Kolkata, Mumbai, New Delhi\",\"eventTitle\":\"Hello Match\",\"eventType\":\"1\",\"eventVenue\":\"Kanala, Andhra Pradesh, India\",\"uploadMediaType\":\"0\",\"invitationCards\":[],\"videoFileURL\":\"https://d2j259rizy5u5h.cloudfront.net/outputvideos/44_2015_03_02_54f462457526c.mp4\",\"videoThumbURL\":\"https://d2j259rizy5u5h.cloudfront.net/outputvideos/thumbs/44_2015_03_02_54f462457526c-00001.png\",\"emailThumbURL\":\"\",\"videoLargeThumbURL\":\"\",\"editEventURL\":\"http://localhost/createevent/edit/ba036d228858d76fb89189853a5503bd\",\"previewEventURL\":\"http://localhost/rd/b1bVR\",\"guestURL\":\"\",\"copyEventURL\":\"http://localhost/createevent/copy/ba036d228858d76fb89189853a5503bd\",\"addGuestsURL\":\"http://localhost/addinvitees/ba036d228858d76fb89189853a5503bd\",\"activityReportURL\":\"http://localhost/activityreport/f457c545a9ded88f18ecee47145a72c0/ba036d228858d76fb89189853a5503bd\",\"eventReminderURL\":\"http://localhost/sendreminder/ba036d228858d76fb89189853a5503bd\",\"upgradeGuestLimitURL\":\"http://localhost/upgradeeventguestlimit/ba036d228858d76fb89189853a5503bd\",\"RSVPEmail\":\"\",\"shareURL\":\"http://localhost/rd/b1bVR\",\"personalizedURL\":\"http://localhost/rd/b1bVR\",\"hashTag\":\"#123 #abc #123saafsdf\",\"DBA\":\"event\",\"isCustomEmailTemplate\":\"0\",\"emailTemplateName\":\"emailTemplate_11473\",\"isCustomEmailSubject\":\"0\",\"emailSubject\":\"\",\"isCustomGuestTemplate\":\"0\",\"guestTemplateName\":\"guestTemplate_11473\",\"guestTemplateID\":\"OTH001\",\"userPaymentType\":\"Premium Event\",\"eventGuestLimit\":\"250\",\"eventVideoLength\":\"00:05:00\",\"emailFromName\":\"\",\"RSVPByDate\":\"\",\"attire\":\"\",\"otherEventsCount\":0,\"groomName\":\"\",\"brideName\":\"\"},\"rsvpCount\":{\"userID\":\"f457c545a9ded88f18ecee47145a72c0\",\"eventID\":\"ba036d228858d76fb89189853a5503bd\",\"yes\":400,\"no\":60,\"mayBe\":40,\"views\":0,\"totalGuests\":500,\"noReply\":0,\"notViewed\":0,\"comments\":0},\"socialCount\":\"\",\"guestList\":\"\"}],\"eventsCount\":73}}";
        Gson gson = new Gson();
        EventLibrary eventLibrary = gson.fromJson(jsonString, EventLibrary.class);
        EventsAdapter adapter = new EventsAdapter(this, eventLibrary.getData().getUserEvents());
        adapter.notifyDataSetChanged();
        listEvents.setAdapter(adapter);*/
    }

    private void getAllEvents(){
        InviterApi.getInstance().getEvents(this, userID, "sent", "6", "0", new Callback<EventLibrary>() {
            @Override
            public void success(EventLibrary eventLibrary, Response response) {
                if (eventLibrary.getStatus().equalsIgnoreCase(AppConfig.successResponse)){
                    EventsAdapter adapter = new EventsAdapter(MainActivity.this, eventLibrary.getData().getUserEvents());
                    adapter.notifyDataSetChanged();
                    listEvents.setAdapter(adapter);
                }else {
                    InviterCore.longSnackbarBuilder(MainActivity.this, eventLibrary.getDescription());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                InviterCore.longSnackbarBuilder(MainActivity.this, error.getMessage());
            }
        });
    }
    @OnClick(R.id.txtDashboard)
    public void onDashboardClick(){

    }

    @OnClick(R.id.txtCreateEvent)
    public void onCreateEventClick(){
        startActivity(new Intent(MainActivity.this, EventInfoActivity.class));
    }
    @OnClick(R.id.txtTerms)
    public void onTermsClick(){

    }
    @OnClick(R.id.txtPrivacyPolicy)
    public void onPrivacyPolicyClick(){

    }

    @OnClick(R.id.btnSignOut)
    public void onSignOutClick(){
        sharedPreferences
                .edit()
                .clear()
                .apply();
        finish();
        startActivity(new Intent(MainActivity.this, SignInActivity.class));
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
