package com.example.inviter.invtandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inviter.invtandroid.R;

import butterknife.ButterKnife;

public class ThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_layout);
        ButterKnife.bind(this);
    }
}
