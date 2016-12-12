package com.example.inviter.invtandroid.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.api.InviterApi;
import com.example.inviter.invtandroid.api.response.encodevideo.EncodeVideoResponseJSON;
import com.example.inviter.invtandroid.api.response.encodevideojob.EncodeJobResponseJSON;
import com.example.inviter.invtandroid.api.uploadResponse.UploadResponse;
import com.example.inviter.invtandroid.config.AppConfig;
import com.example.inviter.invtandroid.core.MessageProgressDialog;
import com.example.inviter.invtandroid.core.Utils;

import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class CreateEventActivity extends AppCompatActivity {

    private CountDownTimer requestTimer;
    private MessageProgressDialog progressDialog;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

    private void init(){
        ButterKnife.bind(this);
        progressDialog = new MessageProgressDialog(this);
    }

    private void uploadVideo(TypedFile typedFile){
        String uploadType = "video";
        progressDialog.showProgress("Please wait...");
        String userID="";
        if (Utils.isNetworkAvailable(this))
            InviterApi.getInstance(this).uploadContent(userID, uploadType, typedFile, new Callback<UploadResponse>() {
                @Override
                public void success(UploadResponse uploadResponse, Response response) {
                    if(uploadResponse.getStatus().equals(AppConfig.successResponse)){
                        //Toast.makeText(getApplicationContext(), uploadResponse.getStatus(), Toast.LENGTH_LONG).show();
                        // btnAddGuests.setVisibility(View.VISIBLE);
                        encodeVideo(uploadResponse);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    progressDialog.dismissProgress();
                    Log.e("HERE", error.getMessage());
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

    private void encodeVideo(UploadResponse uploadResponse){
        String userID="", videoLength="";
        InviterApi.getInstance(CreateEventActivity.this).encodeVideo(userID,
                uploadResponse.getData().getFilePath(), uploadResponse.getData().getS3FilePath(),
                uploadResponse.getData().getBaseURL(), uploadResponse.getData().getFileType(),
                uploadResponse.getData().getServerIp(), videoLength, new Callback<EncodeVideoResponseJSON>() {
                    @Override
                    public void success(EncodeVideoResponseJSON encodeVideoResponseJSON, Response response) {
                        if (encodeVideoResponseJSON.status.equals(AppConfig.successResponse)) {

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
                    }
                });
    }

    private void trackEncodeStatus(final EncodeVideoResponseJSON encodeVideoResponseJSON){
        requestTimer = new CountDownTimer(120000, 5000){
            @Override
            public void onTick(final long millisUntilFinished) {
                InviterApi.getInstance(CreateEventActivity.this).getEncodeStatus(userID,
                        encodeVideoResponseJSON.data.jobID,
                        new Callback<EncodeJobResponseJSON>() {
                            @Override
                            public void success(EncodeJobResponseJSON encodeJobResponseJSON, Response response) {
                                //Toast.makeText(getApplicationContext(), String.valueOf(millisUntilFinished / 1000) + encodeJobResponseJSON.data.jobStatus, Toast.LENGTH_SHORT).show();
                                if (encodeJobResponseJSON.data.jobStatus.equals(AppConfig.successResponse))
                                {
                                    /*requestTimer.cancel();
                                    progressDialog.dismiss();
                                    encodeStatus = encodeJobResponseJSON.data.jobStatus;
                                    CreateEventJSON.getInstance().eventDetails.videoFileURL = encodeJobResponseJSON.data.videoFile;
                                    CreateEventJSON.getInstance().eventDetails.emailThumbURL = encodeJobResponseJSON.data.emailThumbFile;
                                    CreateEventJSON.getInstance().eventDetails.videoThumbURL = encodeJobResponseJSON.data.thumbFile;
                                    Log.e("RAVI", encodeJobResponseJSON.data.jobStatus);
                                    Toast.makeText(getApplicationContext(), encodeJobResponseJSON.data.videoFile, Toast.LENGTH_SHORT).show();
                                    btnAddGuests.setEnabled(true);*/
                                }
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                progressDialog.dismissProgress();
                            }
                        });
            }

            @Override
            public void onFinish() {

            }
        };
        requestTimer.start();
    }
}
