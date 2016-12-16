package com.example.inviter.invtandroid.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.response.createevent.CreateEvent;
import com.example.inviter.invtandroid.api.response.createevent.CreateEventResponse;
import com.example.inviter.invtandroid.api.response.encodevideo.EncodeVideoResponseJSON;
import com.example.inviter.invtandroid.api.response.encodevideojob.EncodeJobResponseJSON;
import com.example.inviter.invtandroid.api.uploadResponse.UploadResponse;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.InviterCore;
import com.example.inviter.invtandroid.core.Loggers;
import com.example.inviter.invtandroid.core.MessageProgressDialog;
import com.example.inviter.invtandroid.core.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class CreateEventActivity extends AppCompatActivity implements OnMapReadyCallback {

    private CountDownTimer requestTimer;
    private MessageProgressDialog progressDialog;
    private String userID;
    private GoogleMap gMap;
    private double lat, lng;
    private SharedPreferences sharedPreferences;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    int videoLengthInSec = 02;
    private static final int SELECT_VIDEO = 3;
    private String selectedPath;
    private CreateEvent createEvent;
    private String videoLength;

    @Bind(R.id.lblEventTitle) TextView lblEventTitle;
    @Bind(R.id.lblEventStartDate) TextView lblEventStartDate;
    @Bind(R.id.lblEventEndDate) TextView lblEventEndDate;
    @Bind(R.id.txtTo) TextView txtTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        init();
    }

    private void init(){
        ButterKnife.bind(this);
        progressDialog = new MessageProgressDialog(this);
        sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        userID = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_USER_ID, "");
        videoLength = sharedPreferences.getString(AppConfig.SHARED_PREFERENCE_KEY_VIDEO_LENGTH, "02:00");
        createEvent = CreateEvent.getInstance();
        if (createEvent.getEventStartDate()!=null) {
            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy");

            try {
                Date startDate = input.parse(createEvent.getEventStartDate());

                lblEventStartDate.setText(output.format(startDate) + " at "
                        + createEvent.getEventStartTime());
                if (!createEvent.getEventEndDate().equals("0000-00-00")){
                    Date endDate = input.parse(createEvent.getEventEndDate());
                    lblEventEndDate.setText(output.format(endDate) + " at "
                            + createEvent.getEventEndTime());
                }else{
                    txtTo.setVisibility(View.GONE);
                    lblEventEndDate.setVisibility(View.GONE);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            lblEventTitle.setText(createEvent.getEventTitle());

        }
        if (createEvent.getEventVenue()!=null) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocationName(createEvent.getEventVenue(), 1);
                if (addresses.size() > 0) {
                    lat = addresses.get(0).getLatitude();
                    lng = addresses.get(0).getLongitude();
                }
            } catch (Exception ex) {
                Loggers.error("MAP ERROR==="+ex.getMessage());
            }
        }
        try {
            if (gMap == null) {
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                mapFragment.getMapAsync(CreateEventActivity.this);
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                gMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.imgPlay)
    public void onPlayClick(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.video_picker_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView fromGallery = (TextView) dialog.findViewById(R.id.lblChooseVideo);
        TextView recordVideo = (TextView) dialog.findViewById(R.id.lblRecordVideo);
        dialog.setCancelable(false);
        dialog.show();
        fromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Select a Video "), SELECT_VIDEO);
            }
        });

        recordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, videoLengthInSec);
                    startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
                }
            }
        });
    }

    private void uploadVideo(TypedFile typedFile){
        String uploadType = "video";
        progressDialog.showProgress("Please wait...");
        String userID="";
        if (Utils.isNetworkAvailable(this))
            InviterApi.getInstance().uploadContent(CreateEventActivity.this, userID, uploadType, typedFile, new Callback<UploadResponse>() {
                @Override
                public void success(UploadResponse uploadResponse, Response response) {
                    if(uploadResponse.getStatus().equals(AppConfig.successResponse)){
                        Loggers.error("CREATE EVENT==SUCCESS ENCODING=="+uploadResponse.getDescription());
                        //Toast.makeText(getApplicationContext(), uploadResponse.getStatus(), Toast.LENGTH_LONG).show();
                        // btnAddGuests.setVisibility(View.VISIBLE);
                        encodeVideo(uploadResponse);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    progressDialog.dismissProgress();
                    Loggers.error("CREATE EVENT==ERROR UPLOAD=="+error.getMessage());
                    InviterCore.longSnackbarBuilder(CreateEventActivity.this, error.getMessage());
                }
            });
        }

    private void encodeVideo(UploadResponse uploadResponse){
        InviterApi.getInstance().encodeVideo(CreateEventActivity.this, userID,
                uploadResponse.getData().getFilePath(), uploadResponse.getData().getS3FilePath(),
                uploadResponse.getData().getBaseURL(), uploadResponse.getData().getFileType(),
                uploadResponse.getData().getServerIp(), videoLength, new Callback<EncodeVideoResponseJSON>() {
                    @Override
                    public void success(EncodeVideoResponseJSON encodeVideoResponseJSON, Response response) {
                        if (encodeVideoResponseJSON.status.equals(AppConfig.successResponse)) {
                            Loggers.error("CREATE EVENT==SUCCESS ENCODING=="+encodeVideoResponseJSON.description);
                                            /*Timer timer = new Timer();
                                            timer.schedule(new TimerTask() {
                                                @Override
                                                public void run() {

                                                }
                                            }, 0, 120);*/
                            trackEncodeStatus(encodeVideoResponseJSON);
                            //Toast.makeText(getApplicationContext(), encodeVideoResponseJSON.data.jobID, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismissProgress();
                        Loggers.error("CREATE EVENT==ERROR ENCODING=="+error.getMessage());
                        InviterCore.longSnackbarBuilder(CreateEventActivity.this, error.getMessage());
                    }
                });
    }

    private void trackEncodeStatus(final EncodeVideoResponseJSON encodeVideoResponseJSON){
        requestTimer = new CountDownTimer(120000, 5000){
            @Override
            public void onTick(final long millisUntilFinished) {
                InviterApi.getInstance().getEncodeStatus(CreateEventActivity.this, userID,
                        encodeVideoResponseJSON.data.jobID,
                        new Callback<EncodeJobResponseJSON>() {
                            @Override
                            public void success(EncodeJobResponseJSON encodeJobResponseJSON, Response response) {
                                //Toast.makeText(getApplicationContext(), String.valueOf(millisUntilFinished / 1000) + encodeJobResponseJSON.data.jobStatus, Toast.LENGTH_SHORT).show();
                                if (encodeJobResponseJSON.data.jobStatus.equals(AppConfig.successResponse)) {
                                    Loggers.error("CREATE EVENT==SUCCESS TRACKING=="+encodeJobResponseJSON.description);
                                    requestTimer.cancel();
                                    progressDialog.dismissProgress();
                                    createEvent.setVideoFileURL(encodeJobResponseJSON.data.videoFile);
                                    createEvent.setEmailThumbURL(encodeJobResponseJSON.data.emailThumbFile);
                                    createEvent.setVideoThumbURL(encodeJobResponseJSON.data.thumbFile);
                                }else{
                                    Loggers.error("CREATE EVENT==ERROR TRACKING=="+encodeJobResponseJSON.description);
                                    InviterCore.longSnackbarBuilder(CreateEventActivity.this, encodeJobResponseJSON.description);
                                }
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Loggers.error("CREATE EVENT==ERROR TRACKING=="+error.getMessage());
                                progressDialog.dismissProgress();
                                InviterCore.longSnackbarBuilder(CreateEventActivity.this, error.getMessage());
                            }
                        });
            }

            @Override
            public void onFinish() {

            }
        };
        requestTimer.start();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_VIDEO) {
            Uri selectedImageUri = data.getData();
            selectedPath = getPath(selectedImageUri);
        }
        else if (requestCode == REQUEST_VIDEO_CAPTURE)
        {
            Uri selectedImageUri = data.getData();
            selectedPath = getPath(selectedImageUri);
        }

        TypedFile typedFile = new TypedFile("multipart/form-data", new File(selectedPath));
        uploadVideo(typedFile);
    }

    private String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();
        cursor = getContentResolver().query(
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        cursor.close();
        return path;
    }

    @OnClick(R.id.imgCalender)
    public void tmp(){
        progressDialog.showProgress("Please wait...");
        InviterApi.getInstance().createEvent(CreateEventActivity.this, userID, createEvent, new Callback<CreateEventResponse>() {
            @Override
            public void success(CreateEventResponse createEventResponse, Response response) {
                progressDialog.dismissProgress();
                Loggers.error("CREATE EVENT==CREATE ENCODING=="+createEventResponse.getDescription());
                InviterCore.longSnackbarBuilder(CreateEventActivity.this, createEventResponse.getDescription());
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismissProgress();
                Loggers.error("CREATE EVENT==ERROR CREATE EVENT=="+error.getMessage());
                InviterCore.longSnackbarBuilder(CreateEventActivity.this, error.getMessage());
            }
        });
    }
}
