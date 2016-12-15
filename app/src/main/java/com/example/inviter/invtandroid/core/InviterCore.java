package com.example.inviter.invtandroid.core;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.example.inviter.invtandroid.activity.SignUpActivity;

/**
 * Created by Ravikant on 06/12/16.
 */

public class InviterCore {

    public static void longToastBuilder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void shortToastBuilder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void longSnackbarBuilder(Context context, String message){
        View view = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static void shortSnackbarBuilder(Context context, String message){
        View view = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    public static String getTimeWithString(String time){
        // time = 12:48:53
        String times[] = time.split(":");
        int hourOfDay = Integer.parseInt(times[0]);
        String format;
        if (hourOfDay == 0) {
            hourOfDay += 12;
            format = " AM";
        } else if (hourOfDay == 12) {
            format = " PM";
        } else if (hourOfDay > 12) {
            hourOfDay -= 12;
            format = " PM";
        } else {
            format = " AM";
        }
        return hourOfDay+":" + times[1] + format;
    }

    public static String getShortDate(String date){
        // date = 2017-11-15
        String[] dates = date.split("-");
        String month="";
        switch (dates[1]){
            case "01":
                month = "Jan";
                break;
            case "02":
                month = "Feb";
                break;
            case "03":
                month = "Mar";
                break;
            case "04":
                month = "Apr";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "Jun";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "Aug";
                break;
            case "09":
                month = "Sep";
                break;
            case "10":
                month = "Oct";
                break;
            case "11":
                month = "Nov";
                break;
            case "12":
                month = "Dec";
                break;
        }
        return dates[2]+" "+ month;
    }
}
